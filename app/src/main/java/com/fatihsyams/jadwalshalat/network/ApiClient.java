package com.fatihsyams.jadwalshalat.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl("https://muslimsalat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
