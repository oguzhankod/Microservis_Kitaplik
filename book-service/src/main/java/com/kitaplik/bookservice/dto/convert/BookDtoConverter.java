package com.kitaplik.bookservice.dto.convert;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.model.Book;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public BookDto convert(Book book){
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .bookYear(book.getBookYear())
                .pressName(book.getPressName()).build();
        return bookDto;
    }

}
