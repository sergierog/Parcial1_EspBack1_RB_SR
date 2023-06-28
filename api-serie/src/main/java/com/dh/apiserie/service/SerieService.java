package com.dh.apiserie.service;

import com.dh.apiserie.event.SerieCreadaEventProducer;
import com.dh.apiserie.model.Serie;
import com.dh.apiserie.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repository;

    private final SerieCreadaEventProducer serieCreadaEventProducer;


    public SerieService(SerieRepository repository, SerieCreadaEventProducer serieCreadaEventProducer) {
        this.repository = repository;
        this.serieCreadaEventProducer = serieCreadaEventProducer;
    }



    public List<Serie> findByGenre(String genre) {
        return repository.findAllByGenre(genre);
    }

    public Serie save(Serie serieDto) {

        repository.save(serieDto);
        serieCreadaEventProducer.publishCrearSerie(serieDto);
        return serieDto;

    }
}
