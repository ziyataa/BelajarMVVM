package com.ziyata.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.ziyata.mvvm.model.MoviesData;
import com.ziyata.mvvm.model.MoviesResponse;
import com.ziyata.mvvm.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<List<MoviesData>> moviesData = new MutableLiveData<>();

    public void setData(String pages, final Context context) {
        Utils.geClient().getMovies(ApiClient.API_KEY, pages)
                .enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            if (response.body().getMoviesDataList() != null) {
                                moviesData.setValue(response.body().getMoviesDataList());
                            } else {
                                Toast.makeText(context, "Data kosong", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public MutableLiveData<List<MoviesData>> getMoviesData() {
        return moviesData;
    }
}
