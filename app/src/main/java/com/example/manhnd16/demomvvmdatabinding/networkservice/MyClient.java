package com.example.manhnd16.demomvvmdatabinding.networkservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyClient {
    private static final String BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/";
    private static MyClient myClient;
    private Retrofit retrofit;

    private MyClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized MyClient getInstance() {
        if (myClient == null) {
            myClient = new MyClient();
        }
        return myClient;
    }

    public ApiService getMyApi() {
        return retrofit.create(ApiService.class);
    }
}
