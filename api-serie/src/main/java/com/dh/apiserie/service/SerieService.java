package com.dh.apiserie.service;

import com.dh.apiserie.model.Serie;
import com.dh.apiserie.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repository;



    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }



    public List<Serie> findByGenre(String genre) {
        return repository.findAllByGenre(genre);
    }

    public Serie save(Serie serieDto) {
        return repository.save(serieDto);
    }
}
