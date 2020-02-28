package com.example.manhnd16.demomvvmdatabinding.networkservice;

import com.example.manhnd16.demomvvmdatabinding.model.MyList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("androidwebmvvm.php")
    Call<ArrayList<MyList>> getartistdata();
}
