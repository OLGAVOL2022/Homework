package com.company.JavaCore.Lesson8;

import com.company.JavaCore.Lesson7.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class WeatherParser {
    private final ObjectMapper objectMapper;

    public WeatherParser() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public List<WeatherResponse> parseResponse(Response response) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(response.body().string())
                .at("/DailyForecasts");

        return objectMapper.convertValue(jsonNode, objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherResponse.class));
    }
}
