package com.serrano.msscbreweryclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClientProperties {

    private final String beerResourcePath;
    private final String customerResourcePath;
    private final String apiHost;

    public BreweryClientProperties(String beerResourcePath, String customerResourcePath, String apiHost) {
        this.beerResourcePath = beerResourcePath;
        this.customerResourcePath = customerResourcePath;
        this.apiHost = apiHost;
    }

    public String getBeerResourcePath() {
        return beerResourcePath;
    }

    public String getCustomerResourcePath() {
        return customerResourcePath;
    }

    public String getApiHost() {
        return apiHost;
    }
}
