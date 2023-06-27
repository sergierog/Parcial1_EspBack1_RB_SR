package com.dh.catalog.Repository;

import com.dh.catalog.Models.movie.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query("{'genre': ?0}")
    List<Movie> findAllByGenre(String genre);

}