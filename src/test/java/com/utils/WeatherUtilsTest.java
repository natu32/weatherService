package com.utils;

import com.exception.WeatherException;
import org.junit.Assert;
import org.junit.Test;

public class WeatherUtilsTest {

    @Test
    public void formatDate() {
        String date = WeatherUtils.formatDate("1558573637");
        Assert.assertEquals("05-22-19 20:07:17", date);
    }

    @Test (expected = WeatherException.class)
    public void formatDateEmpty() {
        String date = WeatherUtils.formatDate("");
        Assert.assertEquals("", date);
    }

    @Test (expected = WeatherException.class)
    public void formatDateNull() {
        String date = WeatherUtils.formatDate(null);
        Assert.assertEquals("05-22-19 20:07:17", date);
    }

    @Test
    public void formatTempF() {
        String tempF = WeatherUtils.formatTempF(10.2);
        Assert.assertEquals("50.36", tempF);
    }

    @Test (expected = WeatherException.class)
    public void formatTempFNull() {
        String tempF = WeatherUtils.formatTempF(null);
        Assert.assertEquals("50.36", tempF);
    }

    @Test
    public void formatTemp() {
        String tempC = WeatherUtils.formatTemp(10.2);
        Assert.assertEquals("10.2", tempC);
    }

    @Test (expected = WeatherException.class)
    public void formatTempNull() {
        String tempC = WeatherUtils.formatTemp(null);
        Assert.assertEquals("10.2", tempC);
    }
}