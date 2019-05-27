package com.ziyata.mvvm;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ziyata.mvvm.databinding.ItemMovieBinding;
import com.ziyata.mvvm.model.MoviesData;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<MoviesData> moviesDataList;

    public MoviesAdapter(List<MoviesData> moviesDataList) {
        this.moviesDataList = moviesDataList;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemMovieBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_movie, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder viewHolder, int i) {
        MoviesData moviesData = moviesDataList.get(i);
        viewHolder.bindItems(moviesData);
    }

    @Override
    public int getItemCount() {
        return moviesDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMovieBinding itemMovieBinding;
        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.itemMovieBinding = binding;
        }

        void bindItems(MoviesData moviesData) {
            itemMovieBinding.setMoviesdata(moviesData);
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500/" + moviesData.getPosterPath())
                    .into(itemMovieBinding.imgMovies);
            itemMovieBinding.executePendingBindings();
        }
    }
}
