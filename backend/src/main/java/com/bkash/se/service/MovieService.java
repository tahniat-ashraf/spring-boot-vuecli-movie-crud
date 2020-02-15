package com.bkash.se.service;

import com.bkash.se.entity.Movie;
import com.bkash.se.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/15/20
 */
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findByName(String name){
        return movieRepository.findByName(name);
    }

    public List<Movie> findByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie){
         return movieRepository.save(movie);
    }

    public void delete(Movie movie){
        movieRepository.delete(movie);
    }





    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
}
