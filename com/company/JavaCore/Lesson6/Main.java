package com.company.JavaCore.Lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

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
                .addQueryParameter("apikey", "sK7bbFPWFuSawDg5TR2CxF9Bos14s9nv")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
