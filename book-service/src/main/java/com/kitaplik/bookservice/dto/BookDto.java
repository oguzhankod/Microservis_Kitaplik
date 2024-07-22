package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String title;
    private int bookYear;
    private String pressName;
    private String isbn;


}
