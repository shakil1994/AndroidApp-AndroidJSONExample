package com.example.shakil.androidjsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shakil.androidjsonexample.Adapter.MovieAdapter;
import com.example.shakil.androidjsonexample.Common.Common;
import com.example.shakil.androidjsonexample.Interface.RetrofitService;
import com.example.shakil.androidjsonexample.Model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerMovie;
    RetrofitService mService;
    RecyclerView.LayoutManager layoutManager;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getMovies();

        recyclerMovie = findViewById(R.id.recyclerMovie);
        recyclerMovie.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerMovie.setLayoutManager(layoutManager);

        getAllMovieList();

    }

    private void getAllMovieList() {
        mService.getAllMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                adapter = new MovieAdapter(getBaseContext(), response.body());
                adapter.notifyDataSetChanged();
                recyclerMovie.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
}
