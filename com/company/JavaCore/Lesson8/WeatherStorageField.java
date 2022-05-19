package com.company.JavaCore.Lesson8;

import lombok.Getter;

public enum WeatherStorageField {
    CITY("city"), LOCAL_DATE("localDate"), WEATHER_TEXT("weatherText"), TEMPERATURE("temperature");

    @Getter
    private final String name;
    WeatherStorageField(String name) {
        this.name = name;
    }
}
