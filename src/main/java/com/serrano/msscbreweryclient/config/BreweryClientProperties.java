package com.serrano.msscbreweryclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClientProperties {

    private final String beerResourcePath;
    private final String apiHost;

    public BreweryClientProperties(String beerResourcePath, String apiHost) {
        this.beerResourcePath = beerResourcePath;
        this.apiHost = apiHost;
    }

    public String getBeerResourcePath() {
        return beerResourcePath;
    }

    public String getApiHost() {
        return apiHost;
    }
}
