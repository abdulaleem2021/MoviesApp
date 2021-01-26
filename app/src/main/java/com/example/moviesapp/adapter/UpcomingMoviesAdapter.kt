package com.example.moviesapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Result
import com.example.moviesapp.model.ResultX


class UpcomingMoviesAdapter(private val context: Context?, private var upComingMoviesList:ArrayList<ResultX>) : RecyclerView.Adapter<UpcomingMoviesAdapter.PostViewHolder>() {

    val moviesImageUrl : String = "https://image.tmdb.org/t/p/original"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.upcoming_movies_rv_layout,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val UpComingMoviesList = upComingMoviesList.get(position)
        holder.title.text = UpComingMoviesList.original_title
        holder.releaseDate.text = UpComingMoviesList.release_date
        holder.popularity.text ="popularity : "+ UpComingMoviesList.popularity.toString()

        val completeUrlMovieImages : String = moviesImageUrl + UpComingMoviesList.poster_path
        Glide.with(context!!).load(completeUrlMovieImages).into(holder.movieImages);
    }

    override fun getItemCount(): Int = upComingMoviesList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val movieImages:ImageView=itemView.findViewById(R.id.iv_topRatedMovies)
        val title: TextView =itemView.findViewById(R.id.tv_moviesName)
        val popularity: TextView =itemView.findViewById(R.id.tv_MovieRating)
        val releaseDate: TextView =itemView.findViewById(R.id.tv_MovieReleaseDate)
    }

    fun setPostData(postList: ArrayList<ResultX>)
    {
        this.upComingMoviesList = postList
        notifyDataSetChanged()
    }
}