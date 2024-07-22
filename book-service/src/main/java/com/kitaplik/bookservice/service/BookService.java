package com.kitaplik.bookservice.service;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.dto.convert.BookDtoConverter;
import com.kitaplik.bookservice.dto.convert.BookIdDtoConverter;
import com.kitaplik.bookservice.exception.BookNotFoundExcepiton;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;
    private final BookIdDtoConverter bookIdDtoConverter;

    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter, BookIdDtoConverter bookIdDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
        this.bookIdDtoConverter = bookIdDtoConverter;
    }

    public List<BookDto> getAllBooks(){

        return bookRepository.findAll()
                .stream()
                .map(bookDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(()->new BookNotFoundExcepiton("Aranılan Kitap Bulunamadı"));
    }

    public BookDto findBookDetailsById(Long id){
        return bookRepository.findById(id)
                .map(bookDtoConverter::convert)
                .orElseThrow(()->new BookNotFoundExcepiton("İd'si verilen kitap bulunamadı"));
    }
}
