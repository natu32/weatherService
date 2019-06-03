package com.connector;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class OpenWeatherConnectionTest {

    @Test
    public void clientWeather(){
        String url = "http://localhost/";
        OpenWeatherConnection openWeatherConnection = new OpenWeatherConnection();

        assertNotNull(openWeatherConnection);

        OpenWeatherClient openWeatherClient = openWeatherConnection.clientWeather(url);

        assertNotNull(openWeatherClient);
    }

}