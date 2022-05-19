package com.company.JavaCore.Lesson8;

import com.company.JavaCore.Lesson7.WeatherResponse;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class WeatherRepository {
    private final WeatherClient weatherClient;
    private final WeatherParser weatherParser;
    private final WeatherStorage weatherStorage;

    public WeatherRepository(WeatherClient weatherClient, WeatherParser weatherParser, WeatherStorage weatherStorage) {
        this.weatherClient = weatherClient;
        this.weatherParser = weatherParser;
        this.weatherStorage = weatherStorage;
    }

    public void loadWeatherNext5day(String city) throws IOException {
        Response response = weatherClient.loadWeathers();
        List<WeatherResponse> weatherResponseList = weatherParser.parseResponse(response);
        weatherStorage.insert(weatherResponseList, city);
    }

    public String getValue(WeatherStorageField column, WeatherStorageField field, double equals) {
        return weatherStorage.getValue(column, field, equals);
    }
}
