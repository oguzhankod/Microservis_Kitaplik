package com.kitaplik.libraryservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookIdDto {
    private Long id;
    private String isbn;
}