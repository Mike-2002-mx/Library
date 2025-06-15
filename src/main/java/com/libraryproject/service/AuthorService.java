package com.libraryproject.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryproject.dto.AuthorResponse;
import com.libraryproject.model.Author;
import com.libraryproject.repository.AuthorRepository;
import com.libraryproject.repository.BookRepository;
import com.libraryproject.repository.BookRepository.BookProjection;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author save(Author author){  
        authorRepository.save(author);
        return author;
    }

    public AuthorResponse getById(Integer id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found"));
        List<BookProjection> books = bookRepository.findBooksByAuthorId(id);
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setAuthorName(author.getAuthorName());
        authorResponse.setBooks(books);
        authorResponse.setNationality(author.getNationality());
        authorResponse.setSurname(author.getSurname());
        return authorResponse;

    }

    public void delete(Integer id){
        authorRepository.deleteById(id);
    }

    public List<Author> findByAuthorName(String authorName){return authorRepository.findByAuthorName(authorName);}

    public List<Author> findByNationality(String nationality){return authorRepository.findByNationality(nationality);}

}

