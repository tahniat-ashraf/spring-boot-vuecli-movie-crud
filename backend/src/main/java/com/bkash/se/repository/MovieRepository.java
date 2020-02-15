package com.bkash.se.repository;

import com.bkash.se.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/15/20
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie,String> {

     Movie findByName(String name);

     List<Movie> findByGenre(String genre);

     List<Movie> findAll();
}
