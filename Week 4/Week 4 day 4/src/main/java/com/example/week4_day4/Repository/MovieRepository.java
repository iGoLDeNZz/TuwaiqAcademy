package com.example.week4_day4.Repository;

import com.example.week4_day4.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByName(String name);

    List<Movie> findMoviesByDirectorId(Integer directorID);

    @Query("select movie from Movie movie where movie.rating >= ?1")
    List<Movie> findMoviesByRating(Integer rating);

    List<Movie> findMoviesByGenre(String genre);

}
