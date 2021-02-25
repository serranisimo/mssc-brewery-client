package com.serrano.msscbreweryclient.web.client;

import com.serrano.msscbreweryclient.config.BreweryClientProperties;
import com.serrano.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    public URI saveNewBeer(BeerDto beerDto){
        return this.restTemplate.postForLocation(
                this.clientProperties.getApiHost() + this.clientProperties.getBeerResourcePath(),
                beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(
                clientProperties.getApiHost() + clientProperties.getBeerResourcePath() + "/" + beerId,
                beerDto
        );
    }

    public void deleteBeer(UUID beerId){
        this.restTemplate.delete(this.clientProperties.getApiHost() + this.clientProperties.getBeerResourcePath() + "/" + beerId);
    }
}
