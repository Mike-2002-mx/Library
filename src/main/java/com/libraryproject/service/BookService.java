package com.libraryproject.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libraryproject.dto.BookRequest;
import com.libraryproject.dto.BookResponse;
import com.libraryproject.model.Author;
import com.libraryproject.model.Book;
import com.libraryproject.model.Collection;
import com.libraryproject.model.Genre;
import com.libraryproject.model.Publisher;
import com.libraryproject.repository.AuthorRepository;
import com.libraryproject.repository.BookRepository;
import com.libraryproject.repository.BookRepository.BookProjection;
import com.libraryproject.repository.CollectionRepository;
import com.libraryproject.repository.GenreRepository;
import com.libraryproject.repository.PublisherRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
	private BookRepository repo;

	@Autowired
	private CollectionRepository collectionsRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired 
	private GenreRepository genreRepository;

	@Autowired
	private ModelMapper modelMapper;


	public List<BookResponse> getAll() {
		return repo.findAll().stream().map(this::mapToDto).toList();
	}



	public BookResponse save(BookRequest book) {
		Collection collection = collectionsRepository.findById(book.getIdCollection()).orElseThrow(() -> new EntityNotFoundException("Collection not found"));
		Author author =authorRepository.findById(book.getIdAuthor()).orElseThrow(() -> new EntityNotFoundException("Author not found"));
		Genre genre =genreRepository.findById(book.getIdGenre()).orElseThrow(() -> new EntityNotFoundException("Genre not found"));
		Publisher publisher = publisherRepository.findById(book.getIdPublisher()).orElseThrow(() -> new EntityNotFoundException("Genre not found"));

		Book newBook = new Book();
		newBook.setTitle(book.getTitle());
		newBook.setAuthor(author);
		newBook.setGenre(genre);
		newBook.setPublisher(publisher);
		newBook.setCollection(collection);
		newBook.setPublicationYear(book.getPublicationYear());
		newBook.setSummary(book.getSummary());
		newBook.setNumberPages(book.getNumberPages());
		newBook.setTotalCopies(book.getTotalCopies());

		Book saveBook = repo.save(newBook);	
		return mapToDto(saveBook);

	}

	private BookResponse mapToDto(Book request){
		BookResponse response = new BookResponse();
		response.setTitle(request.getTitle());
		response.setAuthorName(request.getAuthor().getAuthorName());
		response.setGenreTitle(request.getGenre().getNameGenre());
		response.setCollectionTitle(request.getCollection().getNameCollection());
		response.setPublisherTitle(request.getPublisher().getNamePublisher());
		response.setSummary(request.getSummary());
		response.setNumberPages(request.getNumberPages());
		response.setPublicationYear(request.getPublicationYear());
		response.setTotalCopies(request.getTotalCopies());
		return response;
	}



    private BookResponse mapToDto(BookProjection request){
		return modelMapper.map(request, BookResponse.class);
	}

	public List<BookResponse> getBooksByAuthorId(Integer AuthorId){
		List<BookProjection> books = repo.findBooksByAuthorId(AuthorId);
		return books.stream().map(this::mapToDto).toList();
	}

	public Book getByIdBook(Integer idBook) {
		return repo.findById(idBook).get();
	}

	public void delete(Integer idBook) {
		repo.deleteById(idBook);
	}
	
}

