package com.model;

import lombok.Data;

/**
 * @author Natalia Stanic
 * Model Class
 */
@Data
public class WeatherResponseModel {
    private String city;
    private String tempC;
    private String tempF;
    private String description;
    private String today;
    private String sunrise;
    private String sunset;

}
