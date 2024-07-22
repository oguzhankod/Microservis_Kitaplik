package com.kitaplik.libraryservice.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest {
    private Long id;
    private String isbn;
}
