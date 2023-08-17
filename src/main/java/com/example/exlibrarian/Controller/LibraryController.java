package com.example.exlibrarian.Controller;

import com.example.exlibrarian.Api.ApiResponse;
import com.example.exlibrarian.Model.Book;
import com.example.exlibrarian.Model.Librarian;
import com.example.exlibrarian.Service.LibraryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/Library")

public class LibraryController {
    private final LibraryService libraryService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(libraryService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addlibrarian(@RequestBody @Valid Librarian librarian){
        libraryService.AddLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("add librarian"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity Updatelibrarian(@PathVariable Integer id, @RequestBody Librarian librarian){
        libraryService.UpdateLibrarian(librarian ,id);
        return ResponseEntity.status(200).body(new ApiResponse("update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletelibrarian(@PathVariable Integer id){
        libraryService.deletelibrary(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete librarian"));
    }
    public ResponseEntity getAllEmail( @PathVariable String Email){
        libraryService.getAllEmail(Email);
        return ResponseEntity.status(200).body(new ApiResponse("found Email"));
    }

}
