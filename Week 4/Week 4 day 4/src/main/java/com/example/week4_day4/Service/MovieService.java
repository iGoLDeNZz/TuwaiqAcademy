package com.example.week4_day4.Service;

import com.example.week4_day4.Repository.DirectorRepository;
import com.example.week4_day4.Repository.MovieRepository;
import com.example.week4_day4.model.Director;
import com.example.week4_day4.model.Movie;
import com.example.week4_day4.util.APIException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private DirectorRepository directorRepository;


    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository){
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findById(id).orElse(null);

        if (oldMovie == null)
            throw new APIException("Movie with id: "+id+" was not found.");

        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id){
        Movie oldMovie = movieRepository.findById(id).orElse(null);

        if (oldMovie == null)
            throw new APIException("Movie with id: "+id+" was not found.");
        movieRepository.deleteById(id);
    }

    public Movie getMovieByTitle(Movie movie){
        if (movie.getName() == null || movie.getName().isEmpty())
            throw new APIException("Movie title is required for the search.");

        Movie result = movieRepository.findMovieByName(movie.getName());
        if (result == null)
            throw new APIException("Movie with title: "+movie.getName()+" was not found.");

        return result;
    }


    public Integer getMovieDurationByName(Movie movie){
        if (movie.getName() == null || movie.getName().isEmpty())
            throw new APIException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByName(movie.getName());
        if (movieResult == null)
            throw new APIException("Movie with title: "+movie.getName()+" was not found.");

        return movieResult.getDuration();
    }

    public String getDirectorNameByMovieName(Movie movie){
        if (movie.getName() == null || movie.getName().isEmpty())
            throw new APIException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByName(movie.getName());
        if (movieResult == null)
            throw new APIException("Movie with title: "+movie.getName()+" was not found.");

        Director director = directorRepository.findById(movieResult.getDirectorId()).orElse(null);
        if (director == null)
            throw new APIException("Unexpected error happened this movie has no director.");

        return director.getName();
    }

    public List<Movie> getMoviesByDirectorId(Director director){
        if (director == null)
            throw new APIException("directory is required.");

        List<Movie> movies = movieRepository.findMoviesByDirectorId(director.getId());
        return movies;
    }

    public Integer getMovieRatingByName(Movie movie){
        if (movie.getName() == null || movie.getName().isEmpty())
            throw new APIException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByName(movie.getName());
        if (movieResult == null)
            throw new APIException("Movie with title: "+movie.getName()+" was not found.");

        return movie.getRating();
    }


    public List<Movie> findMoviesByRating(Movie movie){
        if (movie.getRating() == null)
            throw new APIException("Movie rating is required.");

        List<Movie> movies = movieRepository.findMoviesByRating(movie.getRating());
        return movies;
    }

    public List<Movie> getMoviesByGenre(Movie movie){
        if (movie.getGenre() == null || movie.getGenre().isEmpty())
            throw new APIException("Movie genre is required.");

        List<Movie> movies = movieRepository.findMoviesByGenre(movie.getGenre());

        return movies;
    }



}
