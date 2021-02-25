package com.serrano.msscbreweryclient.web.client;

import com.serrano.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        System.out.println(beerDto.toString());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beer = BeerDto.builder().beerName("Test Beer").beerStyle("Pale ale").build();

        URI uri = breweryClient.saveNewBeer(beer);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Oleeee Servesita").build();

        Assertions.assertDoesNotThrow(() -> this.breweryClient.updateBeer(beerDto.getId(), beerDto));
    }

    @Test
    void deleteBeer() {
        UUID beerId = UUID.randomUUID();
        Assertions.assertDoesNotThrow(() -> {
            this.breweryClient.deleteBeer(beerId);
        });
    }
}