package com.bkash.se.controller;

import com.bkash.se.entity.Movie;
import com.bkash.se.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class MovieController {

    private final MovieService movieService;

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        log.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @PostMapping("/findByName")
    public Movie findByName(@RequestBody Map<String, String> map) {
        return movieService.findByName(map.get("name"));
    }

    @PostMapping("/findByGenre")
    public List<Movie> findByGenre(@RequestBody Map<String, String> map) {
        return movieService.findByGenre(map.get("genre"));
    }

    @PostMapping("/save")
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Movie movie) {
        movieService.delete(movie);
    }

    @GetMapping("/findAll")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

}
