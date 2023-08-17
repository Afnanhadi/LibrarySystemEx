package com.example.exlibrarian.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(unique = true)
    private String title;
    private String Author;
    @Column(columnDefinition = "varchar(9) check(Category='Academic ' or Category='Category' or Category='Novel' )")
    private String Category;
    private Integer ISBN;
    @Size(min = 50)
    private  Integer numberOfPages;
}
