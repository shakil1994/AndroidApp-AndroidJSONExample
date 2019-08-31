package com.example.shakil.androidjsonexample.Common;

import com.example.shakil.androidjsonexample.Interface.RetrofitService;
import com.example.shakil.androidjsonexample.Retrofit.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    public static RetrofitService getMovies(){
        return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
    }
}
