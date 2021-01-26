package com.example.moviesapp.networkApiServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

class  RetrofitObject {

    companion object{

        const val url="https://api.themoviedb.org/3/movie/"
        const val apiKey="08981cf49c6741b1943e336655e151ec"

        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api:MoviesApi by lazy {
            retrofit.create(MoviesApi::class.java)
        }
    }
}