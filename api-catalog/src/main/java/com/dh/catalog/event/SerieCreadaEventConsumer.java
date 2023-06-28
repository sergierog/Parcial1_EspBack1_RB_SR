package com.dh.catalog.event;

import com.dh.catalog.Models.serie.Serie;
import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SerieCreadaEventConsumer {

    private final CatalogService catalogService;

    public SerieCreadaEventConsumer(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SERIE_CREADA)
    public void listen(Serie serie) {
        catalogService.saveSerie(serie);
    }

}