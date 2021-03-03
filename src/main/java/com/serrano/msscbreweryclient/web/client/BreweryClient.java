package com.serrano.msscbreweryclient.web.client;

import com.serrano.msscbreweryclient.config.BreweryClientProperties;
import com.serrano.msscbreweryclient.web.model.BeerDto;
import com.serrano.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    private final RestTemplate restTemplate;
    private String apiHost;
    private String beerResourcePath;
    private String customerResourcePath;

    public BreweryClient(BreweryClientProperties clientProperties, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        apiHost = clientProperties.getApiHost();
        beerResourcePath = clientProperties.getBeerResourcePath();
        customerResourcePath = clientProperties.getCustomerResourcePath();
    }

    public BeerDto getBeerById(UUID beerId) {
        return this.restTemplate.getForObject(apiHost + beerResourcePath + "/" + beerId.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return this.restTemplate.postForLocation(
                apiHost + beerResourcePath,
                beerDto);
    }

    public void updateCustomer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(
                apiHost + beerResourcePath+ "/" + beerId,
                beerDto
        );
    }

    public void deleteBeer(UUID beerId){
        this.restTemplate.delete(apiHost + beerResourcePath + "/" + beerId);
    }

    public CustomerDto getCustomerById(UUID id) {
        return this.restTemplate.getForObject(
                apiHost + "/" + customerResourcePath + "/" + id.toString(),
                CustomerDto.class
        );
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return this.restTemplate.postForLocation(
                apiHost + customerResourcePath,
                customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(
                apiHost + customerResourcePath + "/" + customerId,
                customerDto
        );
    }

    public void deleteCustomer(UUID id){
        this.restTemplate.delete(apiHost + customerResourcePath + "/" + id);
    }
}
