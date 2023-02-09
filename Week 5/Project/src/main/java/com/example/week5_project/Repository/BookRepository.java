package com.example.week5_project.Repository;

import com.example.week5_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByNameEquals(String name);
    List<Book> findAllByGenreEquals(String genre);
}
