package com.example.book_service.controlers;

import com.example.book_service.BookServiceApplication;
import com.example.book_service.model.dtos.BookRequest;
import com.example.book_service.model.dtos.BookResponse;
import com.example.book_service.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook (@RequestBody BookRequest bookRequest) { this.bookService.addBook(bookRequest);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks(){
        return this.bookService.getAllBooks();
    }

}
