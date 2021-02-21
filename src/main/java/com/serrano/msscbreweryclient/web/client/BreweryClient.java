package com.serrano.msscbreweryclient.web.client;

import com.serrano.msscbreweryclient.config.BreweryClientProperties;
import com.serrano.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class BreweryClient {

    private final RestTemplate restTemplate;

    BreweryClientProperties clientProperties;

    public BreweryClient(BreweryClientProperties clientProperties, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.clientProperties = clientProperties;
    }

    public BeerDto getBeerById(UUID beerId) {
        var apiHost = clientProperties.getApiHost();
        var beerResourcePath = clientProperties.getBeerResourcePath();
        return this.restTemplate.getForObject(apiHost + beerResourcePath + "/" + beerId.toString(), BeerDto.class);
    }
}
