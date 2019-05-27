package com.ziyata.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("results")
    private List<MoviesData> moviesDataList;

    public List<MoviesData> getMoviesDataList() {
        return moviesDataList;
    }
}
