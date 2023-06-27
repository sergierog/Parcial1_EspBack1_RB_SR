package com.dh.catalog.service;

import com.dh.catalog.Models.movie.Movie;
import com.dh.catalog.Models.serie.Serie;
import com.dh.catalog.Repository.MovieRepository;
import com.dh.catalog.Repository.SerieRepository;
import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CatalogService {

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

  public List<Movie> getMoviesByGenre(String genre) {
    return movieServiceClient.getMovieByGenre(genre);
  }

  public List<Serie> getSeriesByGenre(String genre) {
    return serieServiceClient.getSeriesByGenre(genre);
  }

  public Map<String, ?> getCatalogByGenre(String genre) {
    return Map.of(
      "movies", getMoviesByGenre(genre),
      "series", getSeriesByGenre(genre));
  }

  public List<Movie> getMoviesByGenre(String genre, Throwable t) {
    return movieRepository.findAllByGenre(genre);
  }

  public List<Serie> getSeriesByGenre(String genre, Throwable t) {
    return serieRepository.findAllByGenre(genre);
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public Serie saveSerie(Serie serie) {
    return serieRepository.save(serie);
  }

}