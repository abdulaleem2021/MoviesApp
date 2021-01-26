package com.example.moviesapp.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.adapter.TopRatedMoviesAdapter
import com.example.moviesapp.databinding.FragmentTopRatedMoviesFreagmentBinding
import com.example.moviesapp.repository.MoviesRepository
import com.example.moviesapp.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_top_rated_movies_freagment.*

/**
 * A simple [Fragment] subclass.
 */
class TopRatedMoviesFreagment : Fragment() {

    private lateinit var binding: FragmentTopRatedMoviesFreagmentBinding
    private lateinit var getTopRatedMovies: MoviesRepository
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_rated_movies_freagment,
            container,
            false
        )

        getTopRatedMovies = MoviesRepository()
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        moviesViewModel.getTopRatedMoviesResponse()


        topRatedMoviesAdapter = TopRatedMoviesAdapter(getContext(), ArrayList())

        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(getContext(),2)
            adapter = topRatedMoviesAdapter
        }

        moviesViewModel.topRatedMoviesResponse.observe(this, Observer {

            topRatedMoviesAdapter.setPostData(it.body()?.results as ArrayList)
            Log.e("MainActivity:", "topRatedMoviesResponse :::: ${it.body()}")
            pgBar.visibility = View.GONE
            binding.rvList.visibility = View.VISIBLE
        })

        return binding.root
    }

}
