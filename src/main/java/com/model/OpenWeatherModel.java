package com.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Natalia Stanic
 * Model Class
 */
@Data
public class OpenWeatherModel {

    private String name;
    private String dt;
    private Map<String, Double> main;
    private List<Map<String, String>> weather;
    private Map<String, String> sys;
}
