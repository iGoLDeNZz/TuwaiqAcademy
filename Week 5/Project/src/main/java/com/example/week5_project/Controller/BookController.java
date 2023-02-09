package com.example.week5_project.Controller;

import com.example.week5_project.DTO.BookDTO;
import com.example.week5_project.Service.BookService;
import com.example.week5_project.model.Book;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/get")
    public ResponseEntity getBook(){
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book was added.");
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity updateBook(@RequestBody @Valid Book book, @PathVariable Integer bookId){
        bookService.updateBook(bookId,book);
        return ResponseEntity.status(200).body("Book updates");
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.status(200).body("Book deleted");
    }

    @PutMapping("/assign/{bookId}/store/{storeId}")
    public ResponseEntity assignStoreToBook(@PathVariable Integer bookId, @PathVariable Integer storeId){
        bookService.assignBookToStore(bookId, storeId);
        return ResponseEntity.status(200).body("Store with id: "+storeId+", was assigned to book: "+bookId);
    }

    @GetMapping("/get/{bookId}/count")
    public ResponseEntity getBookCount(@PathVariable Integer bookId){
        return ResponseEntity.status(200).body(bookService.booksAvailableForBook(bookId));
    }

    @GetMapping("/get/name")
    public ResponseEntity getBookByName(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(200).body(bookService.getBookByName(bookDTO.getName()));
    }

    @GetMapping("/get/genre")
    public ResponseEntity getBooksByGenre(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(200).body(bookService.getBooksByGenre(bookDTO.getGenre()));
    }
}
