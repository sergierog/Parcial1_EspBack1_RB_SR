package com.dh.catalog.Models;

import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
public class Catalogo {


        private List<MovieServiceClient.MovieDto> movies = new ArrayList<>();
        private List<SerieServiceClient.SerieDto> series = new ArrayList<>();



}
