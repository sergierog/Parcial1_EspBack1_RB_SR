package com.dh.catalog.Repository;

import com.dh.catalog.Models.Catalogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<Catalogo, String> {
}
