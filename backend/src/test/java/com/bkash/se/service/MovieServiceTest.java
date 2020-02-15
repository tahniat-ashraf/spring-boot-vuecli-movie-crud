package com.bkash.se.service;

import com.bkash.se.entity.Movie;
import com.bkash.se.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/16/20
 */
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void test(){
        List<Movie> movies = movieRepository.findAll();
        System.out.println(movies);

        assert movies.size()==2;

        List<Movie> romantic = movieRepository.findByGenre("Romantic");
        System.out.println("romantic = " + romantic);

        assert romantic.size()==1;

        Movie titanic = movieRepository.findByName("Titanic");
        System.out.println("titanic = " + titanic);

        assert titanic.getGenre().compareTo("Romantic")==0;

        Movie movie=Movie.builder()
                .genre("War")
                .name("Pearl Harbour")
                .build();

        Movie movie1=Movie.builder()
                .genre("Romantic")
                .name("A Lake House")
                .build();

        movieRepository.save(movie);
        movieRepository.save(movie1);

        List<Movie> all = movieRepository.findAll();

        System.out.println("all = " + all);

        assert all.size()==4;

        movieRepository.delete(movie);

        List<Movie> all1 = movieRepository.findAll();

        System.out.println("all1 = " + all1);


        assert all1.size()==3;

    }
}
