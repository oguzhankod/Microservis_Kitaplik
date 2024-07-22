package com.kitaplik.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id ;
    private String title;
    private int year;
    private String author;
    private String pressName ;
}
