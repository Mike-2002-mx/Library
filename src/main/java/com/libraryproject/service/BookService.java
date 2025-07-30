package com.libraryproject.service;

import java.util.List;
import java.util.stream.Collectors;

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


	public List<BookResponse> getAll() {
		return repo.findAll().stream().map(this::mapToDto).toList();
	}



	public BookResponse save(BookRequest book) {
		Collection collection = collectionsRepository.findById(book.getIdCollection()).orElseThrow(() -> new EntityNotFoundException("Collection not found"));
		List<Author> authors = authorRepository.findAllById(book.getIdAuthors());
		List<Genre> genres = genreRepository.findAllById(book.getIdGenres());
		Publisher publisher = publisherRepository.findById(book.getIdPublisher()).orElseThrow(() -> new EntityNotFoundException("Genre not found"));

		Book newBook = new Book();
		newBook.setTitle(book.getTitle());
		newBook.setAuthors(authors.stream().collect(Collectors.toSet()));
		newBook.setGenres(genres.stream().collect(Collectors.toSet()));
		newBook.setPublisher(publisher);
		newBook.setCollection(collection);
		newBook.setPublicationYear(book.getPublicationYear());
		newBook.setSummary(book.getSummary());
		newBook.setNumberPages(book.getNumberPages());
		newBook.setTotalCopies(book.getTotalCopies());

		Book saveBook = repo.save(newBook);	
		return mapToDto(saveBook);

	}

	private BookResponse mapToDto(Book entity){
		BookResponse response = new BookResponse();
		response.setGenreTitles(entity.getGenres()
			.stream()
			.map(Genre::getNameGenre)
			.collect(Collectors.toSet())
			);
		response.setAuthorNames(entity.getAuthors()
			.stream()
			.map(Author::getAuthorName)
			.collect(Collectors.toSet())
			);
		response.setTitle(entity.getTitle());
		response.setCollectionTitle(entity.getCollection().getNameCollection());
		response.setPublisherTitle(entity.getPublisher().getNamePublisher());
		response.setSummary(entity.getSummary());
		response.setNumberPages(entity.getNumberPages());
		response.setPublicationYear(entity.getPublicationYear());
		response.setTotalCopies(entity.getTotalCopies());
		return response;
	}

	public Book getByIdBook(Integer idBook) {
		return repo.findById(idBook).get();
	}

	public void delete(Integer idBook) {
		repo.deleteById(idBook);
	}
	
}

