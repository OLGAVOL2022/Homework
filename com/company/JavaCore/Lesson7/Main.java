package com.company.JavaCore.Lesson7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day") // на 5 дней
                .addPathSegment("332287") // St. Petersburg key
                .addQueryParameter("apikey", "3HGjhv3eB3uJMeYpJsZ0YkKc7BlL2TRD")
                .addQueryParameter("language", "ru")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        JsonNode jsonNode = objectMapper.readTree(response.body().string())
                .at("/DailyForecasts");

        List<WeatherResponse> weatherResponses = objectMapper.convertValue(jsonNode, objectMapper.getTypeFactory().constructCollectionType(List.class, WeatherResponse.class));

        for (WeatherResponse weatherResponse : weatherResponses) {
            StringBuilder builder = new StringBuilder();
            builder.append("| В городе Санкт-Петербург на дату ")
                    .append(weatherResponse.getDate().format(DateTimeFormatter.ofPattern("dd MMM")))
                    .append(" ожидается ")
                    .append(weatherResponse.getDay().getIconPhrase())
                    .append(", температура: минимальная ")
                    .append(weatherResponse.getTemperature().getMinimum().getCelsiusFormat())
                    .append(" и максимальная ")
                    .append(weatherResponse.getTemperature().getMaximum().getCelsiusFormat())
                    .append(" |");
            System.out.println(builder);
        }
    }
}

