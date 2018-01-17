package com.example.slytherin.rxjavaandnetcode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Slytherin on 2018/1/17.
 */

interface NoParmPost {
    @POST("/")
    Call<String> PostWithoutParams();
}

interface NoParmGet{
    @GET("/")
    Call<String> GetWithoutPram();
}