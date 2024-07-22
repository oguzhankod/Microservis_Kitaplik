package com.kitaplik.libraryservice.service;

import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.dto.request.AddBookRequest;
import com.kitaplik.libraryservice.exception.LibraryNotFoundError;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }


    public LibraryDto getAllBookInLibraryById(Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(()->new LibraryNotFoundError("Bulıunmadı"));


        List<String> userList = library.getUserBook()
                .stream()
                .map(book -> {
                    ResponseEntity<BookDto> response = bookServiceClient.getBookDetailsById(book);
                    if (response != null && response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                        BookDto bookDetails = response.getBody();
                        return bookDetails.toString(); // Veya bookDetails.getSomeField() gibi bir metod çağrısı
                    } else {
                        // Hata durumunu yönetmek için burada bir işlem yapabilirsiniz
                        return "No details available"; // veya null döndürebilirsiniz
                    }
                })
                .collect(Collectors.toList());


        LibraryDto libraryDto = new LibraryDto(library.getId(), userList);
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library library = new Library();
        Library newLibrary = libraryRepository.save(library);

        LibraryDto libraryDto = new LibraryDto(newLibrary.getId(), newLibrary.getUserBook());
        return libraryDto;
    }

    public void addBookToLibrary(AddBookRequest request){
        Long bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getId();

        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(()->new LibraryNotFoundError("Aranan ıd li kitap bulunamadı"));

        library.getUserBook().add(String.valueOf(bookId));
        libraryRepository.save(library);

    }

}
