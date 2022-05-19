package com.company.JavaCore.Lesson8;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherClient {
    private final OkHttpClient okHttpClient;
    private final String apiKey;
    private final String cityKey;

    public WeatherClient(String apiKey, String cityKey) {
        okHttpClient = new OkHttpClient();
        this.apiKey = apiKey;
        this.cityKey = cityKey;
    }

    public Response loadWeathers() throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day") // на 5 дней
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("language", "ru")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .build();

        return okHttpClient.newCall(request).execute();
    }
}
