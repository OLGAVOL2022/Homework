package com.company.JavaCore.Lesson8;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        WeatherClient weatherClient = new WeatherClient("3HGjhv3eB3uJMeYpJsZ0YkKc7BlL2TRD", "332287");
        WeatherParser weatherParser = new WeatherParser();
        WeatherStorage weatherStorage = new WeatherStorage();
        WeatherRepository weatherRepository = new WeatherRepository(weatherClient, weatherParser, weatherStorage);

        weatherRepository.loadWeatherNext5day("Санкт-Петербург");

        System.out.println(weatherRepository.getValue(WeatherStorageField.LOCAL_DATE, WeatherStorageField.TEMPERATURE, 68.0));

        weatherStorage.close();
    }
}
