package com.example.exlibrarian.Controller;

import com.example.exlibrarian.Api.ApiResponse;
import com.example.exlibrarian.Model.Book;
import com.example.exlibrarian.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
   private final BookService bookService;
    @GetMapping("/get")

    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        bookService.AddBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("add book"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateBook(@PathVariable Integer id, @RequestBody Book book){
        bookService.UpdateBook(book,id);
        return ResponseEntity.status(200).body(new ApiResponse("update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete book"));
    }
}
