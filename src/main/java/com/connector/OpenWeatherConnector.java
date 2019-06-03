package com.connector;

import com.model.OpenWeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Natalia Stanic
 * Connector class to the openWeather service.
 */
public interface OpenWeatherConnector {

    @GET("/data/2.5/weather")
    Call<OpenWeatherModel> getWeatherByCity(@Query("q") String city, @Query("APPID") String key, @Query("units") String unit);

}
