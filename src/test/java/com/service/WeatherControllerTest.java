package com.service;

import com.connector.OpenWeatherClient;
import com.connector.OpenWeatherConnection;
import com.exception.WeatherException;
import com.model.OpenWeatherModel;
import com.model.WeatherResponseModel;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherControllerTest {


    @Mock
    private OpenWeatherConnection openWeatherConnection;


    @InjectMocks
    private WeatherController weatherController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWeatherByCity() throws WeatherException, IOException {
        weatherController.setBaseUrl("http://api.openweathermap.org");
        weatherController.setUnit("metric");
        weatherController.setKey("234254");

        OpenWeatherClient openWeatherClient = mock(OpenWeatherClient.class);


        OpenWeatherModel model = createOpenWeatherModel();


        when(openWeatherClient.getWeatherByCity("London","576575","metric"))
                .thenReturn(model);


        WeatherResponseModel response = weatherController.getWeatherByCity("London");
        Assert.assertNotNull(response);

    }

    @Test(expected = WeatherException.class)
    public void getWeatherByCityConnectionError() throws IOException {
        weatherController.setBaseUrl("http://local");
        weatherController.setUnit("metric");
        weatherController.setKey("234254");

        OpenWeatherClient openWeatherClient = mock(OpenWeatherClient.class);


        OpenWeatherModel model = createOpenWeatherModel();


        when(openWeatherClient.getWeatherByCity("London","576575","metric"))
                .thenReturn(model);


        WeatherResponseModel response = weatherController.getWeatherByCity("London");

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