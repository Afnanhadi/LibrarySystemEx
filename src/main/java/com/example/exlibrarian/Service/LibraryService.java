package com.example.exlibrarian.Service;

import com.example.exlibrarian.Api.ApiException;
import com.example.exlibrarian.Model.Book;
import com.example.exlibrarian.Model.Librarian;
import com.example.exlibrarian.Repostory.LibraryRepostory;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepostory libraryRepostory;

    public List<Librarian> getAll(){
    return libraryRepostory.findAll();
    }
    public void AddLibrarian(Librarian librarian){
        libraryRepostory.save(librarian);
    }
    public void UpdateLibrarian(Librarian librarian, Integer id){
        Librarian librarian1=libraryRepostory.findLibrarianById(id);
        if(librarian1==null){
            throw new ApiException("id not found");

        }
        librarian1.setEmail(librarian.getEmail());
        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        libraryRepostory.save(librarian1);
    }
    public void deletelibrary(Integer id){
        Librarian librarian=libraryRepostory.findLibrarianById(id);
        if (librarian==null){
            throw new ApiException("not found id");
        }
        libraryRepostory.delete(librarian);
    }
    public List<Librarian> getAllEmail(String Email){
        List <Librarian> librarians =libraryRepostory.findLibrarianByEmail(Email);
        if (librarians.isEmpty()){
            throw new ApiException("is Empty");
        }
        return librarians;
    }
    //public Boolean Login(String Password, String  Username){
       // Librarian librarian=libraryRepostory.findLibrarianByUsernameAndEmail(Password, Username);
       // if (librarian==null){
         //   throw new ApiException("not found Username and Password ");
      //  }
     // librarian.setPassword(librarian.getPassword());
      //  librarian.setUsername(librarian.getUsername());
       // libraryRepostory.equals(librarian)
    //}
}
