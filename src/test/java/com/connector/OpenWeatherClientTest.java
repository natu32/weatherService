package com.connector;

import com.model.OpenWeatherModel;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OpenWeatherClientTest {

    @Mock
    private OpenWeatherConnector openWeatherConnector;

    @InjectMocks
    private OpenWeatherClient openWeatherClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWeatherByCity() throws IOException {
        Call<OpenWeatherModel> call = mock(Call.class);

        OpenWeatherModel model = new OpenWeatherModel();
        model.setName("London");

        when(call.execute()).thenReturn(Response.success(model));
        when(openWeatherConnector.getWeatherByCity("London","65765765","metric")).thenReturn(call);

        OpenWeatherModel openWeatherModel = openWeatherClient.getWeatherByCity("London","65765765","metric");
        Assert.assertEquals(openWeatherModel.getName() ,model.getName());
    }

    @Test
    public void getWeatherByCityEmpty() throws IOException {
        Call<OpenWeatherModel> call = mock(Call.class);
        when(call.request()).thenReturn(new Request.Builder().url("http://localhost/").build());
        when(call.execute()).thenReturn(Response.<OpenWeatherModel>error(404, ResponseBody.create(MediaType.parse("application/json"), "{}")));
        when(openWeatherConnector.getWeatherByCity("","65765765","metric")).thenReturn(call);

        OpenWeatherModel openWeatherModel = openWeatherClient.getWeatherByCity("","65765765","metric");
        Assert.assertEquals(openWeatherModel, null);

    }

}