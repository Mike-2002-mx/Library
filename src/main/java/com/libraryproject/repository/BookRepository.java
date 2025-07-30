package com.libraryproject.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import com.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{


}