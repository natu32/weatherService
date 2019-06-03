package com.mapper;

import com.model.OpenWeatherModel;
import com.model.WeatherResponseModel;
import com.utils.WeatherUtils;

/**
 * @author Natalia Stanic
 * Mapper class.
 */
public class WeatherResponseMapper {

    private WeatherResponseMapper(){
    }

    /**
     * Mapper method to transform from OpenWeatherModel to WeatherResponseModel.
     * @param openWeatherModel openWeather model
     * @return the WeatherResponseModel transformed.
     */
    public static WeatherResponseModel mapWeatherResponse(OpenWeatherModel openWeatherModel){
        WeatherResponseModel response = new WeatherResponseModel();
        if (openWeatherModel != null) {
            response.setCity(openWeatherModel.getName());
            response.setTempC(WeatherUtils.formatTemp(openWeatherModel.getMain().get("temp")));
            response.setTempF(WeatherUtils.formatTempF(openWeatherModel.getMain().get("temp")));
            response.setSunset(WeatherUtils.formatDate(openWeatherModel.getSys().get("sunset")));
            response.setSunrise(WeatherUtils.formatDate(openWeatherModel.getSys().get("sunrise")));
            response.setToday(WeatherUtils.formatDate(openWeatherModel.getDt()));
            response.setDescription(openWeatherModel.getWeather().get(0).get("description"));
        }
        return response;
    }




}
