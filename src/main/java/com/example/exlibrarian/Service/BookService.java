package com.example.exlibrarian.Service;

import com.example.exlibrarian.Api.ApiException;
import com.example.exlibrarian.Model.Book;
import com.example.exlibrarian.Repostory.BookRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepostory bookRepostory;
    public List<Book> getAll(){
        return bookRepostory.findAll();
    }
    public void AddBook(Book book){
        bookRepostory.save(book);
    }
    public void UpdateBook(Book book, Integer id){
        Book book1=bookRepostory.findBookById(id);
        if(book1==null){
            throw new ApiException("id not found");
        }
        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setTitle(book.getTitle());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());
        bookRepostory.save(book1);
    }
    public void deleteBook(Integer id){
        Book book3=bookRepostory.findBookById(id);
        if (book3==null){
            throw new ApiException("not found id");
        }
        bookRepostory.delete(book3);
    }
    public List<Book> getAllCategory(String Category){
        List<Book> books=bookRepostory.findBookByCategory(Category);
        if (Category.isEmpty()){
            throw new ApiException("is Empty");
        }
        return books;
    }
    public List<Book> getAllAuthor(String Author){
        List<Book> books=bookRepostory.findBookByAuthor(Author);
        if (Author.isEmpty()){
            throw new ApiException("is Empty");
        }
        return books;
    }
    public List<Book> getAllTitle(String Title){
        List<Book> books=bookRepostory.findBookByTitle(Title);
        if (Title.isEmpty()){
            throw new ApiException("is Empty");
        }
        return books;
    }
   /* public List<Book> getBookPages(Integer NumberOfPages, String id){
     List<Book> books1=bookRepostory.findBookByNumberOfPages(NumberOfPages);
     if (books1==null){
         throw new ApiException("is Empty");
     } b


    }*/


}
