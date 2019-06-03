package com.utils;

import com.exception.WeatherException;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Natalia Stanic
 *
 * This is an utils class to format some information
 */
public class WeatherUtils {

    /**
     * Format date to mm-dd-yy hh:mm:ss.
     * @param date date to forma
     * @return date formatted
     */
    public static String formatDate(String date){

        if(StringUtils.isEmpty(date)){
            throw new WeatherException("Date can't be null", new Exception());
        }
        String response="";
        if (date != null) {
            String pattern = "MM-dd-yy HH:mm:ss";
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat(pattern);
            response = simpleDateFormat.format(new Date(Long.parseLong(date) * 1000L));
        }
        return response;
    }

    /**
     * Format and transform temperature from celsius to F.
     * @param temp temperature to format.
     * @return temperatures formatted.
     */
    public static String formatTempF(Double temp){
        if(temp == null){
            throw new WeatherException("Temperature can't be null", new Exception());
        }
        return formatTemp((temp * 9.0 / 5.0) + 32.0);
    }

    /**
     * Formate temperatur.
     * @param temp temperature to format
     * @return temperature formatted.
     */
    public static String formatTemp(Double temp){
        if(temp == null){
            throw new WeatherException("Temperature can't be null", new Exception());
        }
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(temp);
    }
}
