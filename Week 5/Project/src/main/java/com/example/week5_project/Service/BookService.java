package com.example.week5_project.Service;

import com.example.week5_project.Repository.BookRepository;
import com.example.week5_project.Utility.APIException;
import com.example.week5_project.model.Book;
import com.example.week5_project.model.Location;
import com.example.week5_project.model.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private StoreService storeService;

    public BookService(BookRepository bookRepository,
                         StoreService storeService){
        this.bookRepository = bookRepository;
        this.storeService = storeService;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookBy(Integer bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null)
            throw new APIException("Book not found", 404);
        return book;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer bookId, Book book){
        Book storedBook = getBookBy(bookId);

        storedBook.setName(book.getName());
        bookRepository.save(storedBook);
    }

    public void deleteBook(Integer bookId){
        getBookBy(bookId);
        bookRepository.deleteById(bookId);
    }

    public void assignBookToStore(Integer bookId, Integer storeId){
        Book book = getBookBy(bookId);
        Store store =  storeService.getStoreBy(storeId);

        book.setStore(store);
        bookRepository.save(book);
    }

    public Integer booksAvailableForBook(Integer bookId){
        Book book = getBookBy(bookId);
        return book.getBookCount();
    }

    public Book getBookByName(String name){
        Book book = bookRepository.findBookByNameEquals(name);

        if (book == null)
            throw new APIException("Book not found", 404);
        return book;
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findAllByGenreEquals(genre);
    }
}
