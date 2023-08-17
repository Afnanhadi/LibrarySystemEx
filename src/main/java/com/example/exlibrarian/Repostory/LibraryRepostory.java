package com.example.exlibrarian.Repostory;

import com.example.exlibrarian.Model.Book;
import com.example.exlibrarian.Model.Librarian;
import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepostory extends JpaRepository<Librarian,Integer> {
    Librarian findLibrarianById(Integer id);
    List<Librarian> findLibrarianByEmail (String Email);
    Librarian findLibrarianByUsernameAndEmail (String Email,String Username);
}
