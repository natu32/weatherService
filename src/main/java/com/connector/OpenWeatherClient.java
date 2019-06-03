package com.connector;

import com.model.OpenWeatherModel;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;

import java.io.IOException;

/**
 * @author Natalia Stanic
 * Client class to call operWeatherService.
 */
public class OpenWeatherClient {

    private final OpenWeatherConnector openWeatherConnector;

    @Inject
    public OpenWeatherClient(OpenWeatherConnector openWeatherConnector) {
        this.openWeatherConnector = openWeatherConnector;
    }

    /**
     * Method that gets the information from the opeweather service api.
     * @param city City from where the weather is requested
     * @param key key to connect to the service
     * @param unit unit to get the information in metric or imperial format
     * @return the openWeatherModel.
     * @throws IOException
     */
    public OpenWeatherModel getWeatherByCity( String city, String key, String unit) throws IOException {

        Call<OpenWeatherModel> call = openWeatherConnector.getWeatherByCity(city, key, unit);
        Response<OpenWeatherModel> response = call.execute();

        return response.body();
    }



}
