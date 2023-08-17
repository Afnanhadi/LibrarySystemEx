package com.example.exlibrarian.Repostory;

import com.example.exlibrarian.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepostory extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    List<Book> findBookByCategory(String Category);
    List<Book> findBookByAuthor (String Author );
    List<Book> findBookByTitle(String Title );
    List<Book> findBookByNumberOfPages(Integer NumberOfPages);

}
