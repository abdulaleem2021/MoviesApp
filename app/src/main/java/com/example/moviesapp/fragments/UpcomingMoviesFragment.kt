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
import com.example.moviesapp.adapter.UpcomingMoviesAdapter
import com.example.moviesapp.databinding.FragmentTopRatedMoviesFreagmentBinding
import com.example.moviesapp.databinding.FragmentUpcomingMoviesBinding
import com.example.moviesapp.model.ResultX
import com.example.moviesapp.repository.MoviesRepository
import com.example.moviesapp.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_top_rated_movies_freagment.*

/**
 * A simple [Fragment] subclass.
 */
class UpcomingMoviesFragment : Fragment() {

    private lateinit var binding: FragmentUpcomingMoviesBinding
    private lateinit var upComingRatedMovies: MoviesRepository
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var upComingMoviesAdapter: UpcomingMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_upcoming_movies,
            container,
            false
        )

        upComingRatedMovies = MoviesRepository()
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        moviesViewModel.getUpComingMovies()


        upComingMoviesAdapter = UpcomingMoviesAdapter(getContext(), ArrayList())

        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(getContext(), 2)
            adapter = upComingMoviesAdapter
        }

        moviesViewModel.upComingMoviesResponse.observe(this, Observer {

            upComingMoviesAdapter.setPostData(it.body()?.results as ArrayList<ResultX>)
            Log.e("UpcomingMoviesFragment:", "UpcomingMoviesResponse :::: ${it.body()}")
            pgBar.visibility = View.GONE
            binding.rvList.visibility = View.VISIBLE
        })

        return binding.root
    }
}
