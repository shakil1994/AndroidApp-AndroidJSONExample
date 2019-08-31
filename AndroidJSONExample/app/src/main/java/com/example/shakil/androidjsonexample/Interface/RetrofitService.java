package com.example.shakil.androidjsonexample.Interface;

import com.example.shakil.androidjsonexample.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("marvel")
    Call<List<Movie>> getAllMovies();
}
