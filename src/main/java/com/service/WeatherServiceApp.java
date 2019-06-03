package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Natalia Stanic
 * Service class
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@PropertySource(name = "EncryptedProperties", value = "classpath:application.properties")
public class WeatherServiceApp {



    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApp.class, args);
    }


}
