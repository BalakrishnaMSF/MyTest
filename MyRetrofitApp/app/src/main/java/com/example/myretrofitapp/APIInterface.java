package com.example.myretrofitapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/posts/{id}")
    Call<PostsItems> getSpecificPost();

}
