package com.service;

import com.connector.OpenWeatherClient;
import com.connector.OpenWeatherConnection;
import com.exception.WeatherException;
import com.mapper.WeatherResponseMapper;
import com.model.OpenWeatherModel;
import com.model.WeatherResponseModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;


@RestController
@Data
public class WeatherController {

    private @Value("${openWeather.key}")  String key;
    private @Value("${openWeather.unit}") String unit;
    private @Value("${openWeather.url}") String baseUrl;

    /**
     * Service to get weather from an specific city.
     * @param city city from were it is required the weather
     * @return the weather information from the city
     * @throws IOException
     */
    @RequestMapping(value = "public/weather/{city}", method = RequestMethod.GET)
    public WeatherResponseModel getWeatherByCity(@PathVariable("city") String city) throws WeatherException {
        OpenWeatherClient openWeatherClient = OpenWeatherConnection.clientWeather(baseUrl);
        OpenWeatherModel openWeatherResponse;
        try {
            openWeatherResponse = openWeatherClient.getWeatherByCity(city, key, unit);
        }
        catch(Exception e){
            throw new WeatherException("the weather service is not working at the moment: ", e.getCause());
        }
        return WeatherResponseMapper.mapWeatherResponse(openWeatherResponse);
    }



}
