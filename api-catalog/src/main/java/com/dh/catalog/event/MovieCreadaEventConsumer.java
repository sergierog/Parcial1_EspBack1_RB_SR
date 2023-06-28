package com.dh.catalog.event;

import com.dh.catalog.Models.movie.Movie;
import com.dh.catalog.Models.serie.Serie;
import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MovieCreadaEventConsumer {

    private final CatalogService catalogService;

    public MovieCreadaEventConsumer(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_MOVIE_CREADA)
    public void listen(Movie movieSQL) {
        Movie movieMongo = new Movie(
          null,
          movieSQL.getName(),
          movieSQL.getGenre(),
          movieSQL.getUrlStream()
        );
        catalogService.saveMovie(movieMongo);
    }

}