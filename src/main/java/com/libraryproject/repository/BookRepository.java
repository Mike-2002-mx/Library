package com.libraryproject.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

     @Query(value = """
        SELECT 
                b.title AS title,
                b.publicationYear AS publicationYear,
                b.summary AS summary,
                b.numberPages AS numberPages,
                b.bookStatus AS bookStatus,
                b.acquisitionDate AS acquisitionDate,
                a.authorName AS authorName,
                g.namegenre AS genreTitle,
                p.namePublisher AS publisherTitle,
                c.collectionTitle AS collectionTitle
        FROM books b
        INNER JOIN authors a
            ON b.idAuthor = a.idAuthor
        INNER JOIN genre g
            ON b.idGenre = g.idGenre
        INNER JOIN publisher p
            ON b.idPublisher = p.idPublisher
        INNER JOIN collections c
            ON b.idCollection = c.idCollection
        WHERE b.idAuthor = :idAuthor
            """, nativeQuery = true)
    public List<BookProjection> findBooksByAuthorId(@Param("idAuthor") Integer idAuthor);



    public interface BookProjection {
        String getCollectionTitle();
        String getTitle();
        String getAuthorName();
        String getGenreTitle();
        String getPublisherTitle();
        Integer getPublicationYear();
        String getSummary();
        Integer getNumberPages();
        String getBookStatus();
        LocalDateTime getAcquisitionDate();
    }


}