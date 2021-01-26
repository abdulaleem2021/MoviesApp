package com.example.moviesapp.networkApiServices

import com.example.moviesapp.model.TopRatedMoviesModel
import com.example.moviesapp.model.UpComingMoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("top_rated")
    suspend fun getTopRatedMoviesApi(@Query("api_key") apiKey: String): Response<TopRatedMoviesModel>

    @GET("upcoming")
    suspend fun getUpComingMoviesApi(@Query("api_key") apiKey: String): Response<UpComingMoviesModel>


}