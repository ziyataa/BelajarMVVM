package com.ziyata.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ziyata.mvvm.databinding.ActivityMainBinding;
import com.ziyata.mvvm.model.MoviesData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = binding.rvMain;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MoviesViewModel viewModel = ViewModelProviders.of(this)
                .get(MoviesViewModel.class);

        Utils.getAlertDialog("Wait", "Loading!!", this);
        viewModel.setData("1", this);
        viewModel.getMoviesData().observe(this, new Observer<List<MoviesData>>() {
            @Override
            public void onChanged(@Nullable List<MoviesData> moviesData) {
                if (moviesData != null) {
                    Utils.cancelAlert();
                    recyclerView.setAdapter(new MoviesAdapter(moviesData));
                }
            }
        });

    }
}
