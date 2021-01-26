package com.example.moviesapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.TopRatedMoviesModel
import com.example.moviesapp.model.UpComingMoviesModel
import com.example.moviesapp.repository.MoviesRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    val topRatedMoviesResponse: MutableLiveData<Response<TopRatedMoviesModel>> = MutableLiveData()
    val upComingMoviesResponse: MutableLiveData<Response<UpComingMoviesModel>> = MutableLiveData()

    fun getTopRatedMoviesResponse() {
        viewModelScope.launch {
            try {
                val response = MoviesRepository().getTopRatedMoviesRep()
                topRatedMoviesResponse.value = response
                Log.e("ViewModel_topRatedMovie", "topRatedMoviesResponse: $topRatedMoviesResponse")

            } catch (e: Exception) {
                Log.e("ViewModel_topRatedMovie", "errorREsponse: ${e.message}")
            }
        }
    }

    fun getUpComingMovies() {
        viewModelScope.launch {
            try {
                val responseUpComingMovies = MoviesRepository().getUpComingMoviesRep()
                upComingMoviesResponse.value = responseUpComingMovies
                Log.e("ViewModel_UpComingMovie", "getUpComingMoviesResponse: $responseUpComingMovies")

            } catch (e: Exception) {
                Log.e("ViewModel_UpComingMovie", "errorREsponse: ${e.message}")
            }
        }
    }
}