package com.dh.catalog.service;

import com.dh.catalog.Models.movie.Movie;
import com.dh.catalog.Models.serie.Serie;
import com.dh.catalog.Repository.MovieRepository;
import com.dh.catalog.Repository.SerieRepository;
import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CatalogService {

  @Lazy
  @Autowired
  private CatalogService self;
  private final MovieRepository movieRepository;
  private final SerieRepository serieRepository;
  private final MovieServiceClient movieServiceClient;
  private final SerieServiceClient serieServiceClient;

  public CatalogService(MovieRepository movieRepository, SerieRepository serieRepository, MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient) {
    this.movieRepository = movieRepository;
    this.serieRepository = serieRepository;
    this.movieServiceClient = movieServiceClient;
    this.serieServiceClient = serieServiceClient;
  }

  @Retry(name = "retryGetMoviesSeriesByGenre")
  @CircuitBreaker(name = "getMoviesSeriesByGenre", fallbackMethod = "getMoviesByGenreFallback")
  public List<Movie> getMoviesByGenre(String genre) {
    return movieServiceClient.getMovieByGenre(genre);
  }

  @Retry(name = "retryGetMoviesSeriesByGenre")
  @CircuitBreaker(name = "getMoviesSeriesByGenre", fallbackMethod = "getSeriesByGenreFallback")
  public List<Serie> getSeriesByGenre(String genre) {
    return serieServiceClient.getSeriesByGenre(genre);
  }

  public Map<String, ?> getCatalogByGenre(String genre) {
    return Map.of(
      "movies", self.getMoviesByGenre(genre),
      "series", self.getSeriesByGenre(genre));
  }

  public List<Movie> getMoviesByGenreFallback(String genre, Throwable t) {
    return movieRepository.findAllByGenre(genre);
  }

  public List<Serie> getSeriesByGenreFallback(String genre, Throwable t) {
    return serieRepository.findAllByGenre(genre);
  }

  public void saveMovie(Movie movie) {
    movieRepository.save(movie);
  }

  public void saveSerie(Serie serie) {
    serieRepository.save(serie);
  }

}