package com.dh.catalog.Models;

import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "Catalogo")
@Builder
@Getter
@Setter
public class Catalogo {

        @Id
        private String id;
        private List<MovieServiceClient.MovieDto> movies = new ArrayList<>();
        private List<SerieServiceClient.SerieDto> series = new ArrayList<>();



}
