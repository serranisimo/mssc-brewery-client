package com.serrano.msscbreweryclient.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(BreweryClientProperties.class)
public class BreweryClientConfiguration {
}
