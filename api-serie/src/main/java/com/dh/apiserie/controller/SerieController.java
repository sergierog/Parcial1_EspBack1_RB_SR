package com.dh.apiserie.controller;

import com.dh.apiserie.model.Serie;
import com.dh.apiserie.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }



    @GetMapping("/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre){
        return ResponseEntity.ok(serieService.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(serieService.save(serie));
    }

}
