package com.example.moviesapp.repository

import com.example.moviesapp.model.TopRatedMoviesModel
import com.example.moviesapp.model.UpComingMoviesModel
import com.example.moviesapp.networkApiServices.RetrofitObject
import retrofit2.Response

class MoviesRepository {

    //TOP Rated Movies Response
    suspend fun getTopRatedMoviesRep(): Response<TopRatedMoviesModel> =
        RetrofitObject.api.getTopRatedMoviesApi(RetrofitObject.apiKey)

    //Upcoming Movies Response
    suspend fun getUpComingMoviesRep(): Response<UpComingMoviesModel> =
        RetrofitObject.api.getUpComingMoviesApi(RetrofitObject.apiKey)
}