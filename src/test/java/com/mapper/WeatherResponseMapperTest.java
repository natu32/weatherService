package com.mapper;

import com.model.OpenWeatherModel;
import com.model.WeatherResponseModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WeatherResponseMapperTest {


    @Test
    public void mapWeatherResponse() {
        WeatherResponseModel response = WeatherResponseMapper.mapWeatherResponse(createOpenWeatherModel());
        Assert.assertEquals("London", response.getCity());
        Assert.assertEquals("10.2", response.getTempC());
        Assert.assertEquals("50.36", response.getTempF());
        Assert.assertEquals("clear sky", response.getDescription());
        Assert.assertEquals("05-22-19 20:07:17", response.getToday());
        Assert.assertEquals("05-22-19 22:58:32", response.getSunrise());
        Assert.assertEquals("05-23-19 14:56:15", response.getSunset());

    }

    private OpenWeatherModel createOpenWeatherModel(){
        OpenWeatherModel model = new OpenWeatherModel();
        model.setName("London");
        model.setDt("1558573637");
        Map<String, Double> main = new HashMap();
        main.put("temp", 10.2);
        model.setMain(main);

        Map<String, String> weather = new HashMap();
        weather.put("description", "clear sky");
        List<Map<String, String>> weatherList = new ArrayList();
        weatherList.add(weather);
        model.setWeather(weatherList);

        Map<String, String> sys = new HashMap();
        sys.put("sunrise","1558583912");
        sys.put("sunset","1558641375");
        model.setSys(sys);
        return model;
    }
}