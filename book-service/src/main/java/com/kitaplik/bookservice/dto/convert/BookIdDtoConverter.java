package com.kitaplik.bookservice.dto.convert;

import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookIdDtoConverter {

    public BookIdDto convertIdDto(Book book){
        BookIdDto bookIdDto = BookIdDto.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .build();

        return bookIdDto;

    }


}
