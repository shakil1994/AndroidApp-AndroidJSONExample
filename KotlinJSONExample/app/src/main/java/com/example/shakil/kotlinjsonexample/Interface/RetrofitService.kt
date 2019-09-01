package com.example.shakil.kotlinjsonexample.Interface

import com.example.shakil.kotlinjsonexample.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}