package com.ziyata.mvvm.network;

import com.ziyata.mvvm.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaces {

    @GET("movie/now_playing")
    Call<MoviesResponse> getMovies(@Query("api_key") String apiKey,
                                   @Query("page") String page);
}
