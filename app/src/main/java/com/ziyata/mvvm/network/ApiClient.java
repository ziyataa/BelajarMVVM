package com.ziyata.mvvm.network;

import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "237abc9b06c308ee14cb2ed15957265f";

    public static Retrofit create() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
