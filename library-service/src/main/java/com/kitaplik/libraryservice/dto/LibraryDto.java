package com.kitaplik.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    private Long id;
    private List<String> userBookList = new ArrayList<>();
}