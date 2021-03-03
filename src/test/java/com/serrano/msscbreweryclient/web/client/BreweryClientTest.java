package com.serrano.msscbreweryclient.web.client;

import com.serrano.msscbreweryclient.web.model.BeerDto;
import com.serrano.msscbreweryclient.web.model.CustomerDto;
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

        Assertions.assertDoesNotThrow(() -> this.breweryClient.updateCustomer(beerDto.getId(), beerDto));
    }

    @Test
    void deleteBeer() {
        UUID beerId = UUID.randomUUID();
        Assertions.assertDoesNotThrow(() -> {
            this.breweryClient.deleteBeer(beerId);
        });
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        System.out.println(customerDto.toString());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Pepe Cliente").build();

        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().uuid(UUID.randomUUID()).name("Pepe Cliente").build();

        assertDoesNotThrow(() -> this.breweryClient.updateCustomer(customerDto.getUuid(), customerDto));
    }

    @Test
    void deleteCustomer() {
        UUID beerId = UUID.randomUUID();
        Assertions.assertDoesNotThrow(() -> {
            this.breweryClient.deleteCustomer(beerId);
        });
    }
}