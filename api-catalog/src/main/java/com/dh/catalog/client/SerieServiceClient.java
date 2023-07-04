package com.dh.catalog.client;

import com.dh.catalog.Models.serie.Serie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name="api-serie")
public interface SerieServiceClient {

	@GetMapping("/api/v1/series/{genre}")
	List<Serie> getSeriesByGenre(@PathVariable (value = "genre") String genre);

}