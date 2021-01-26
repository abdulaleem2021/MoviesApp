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


class TopRatedMoviesAdapter(private val context: Context?, private var topRatedMoviesList:ArrayList<Result>) : RecyclerView.Adapter<TopRatedMoviesAdapter.PostViewHolder>() {

    val moviesImageUrl : String = "https://image.tmdb.org/t/p/original"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_rated_movies_rv_layout,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val topRatedMovies = topRatedMoviesList.get(position)
        holder.title.text = topRatedMovies.original_title
        holder.popularity.text ="popularity : "+ topRatedMovies.popularity.toString()
        val completeUrlMovieImages : String = moviesImageUrl + topRatedMovies.poster_path
        Glide.with(context!!).load(completeUrlMovieImages).into(holder.movieImages);
    }

    override fun getItemCount(): Int = topRatedMoviesList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val movieImages:ImageView=itemView.findViewById(R.id.iv_topRatedMovies)
        val title: TextView =itemView.findViewById(R.id.tv_moviesName)
        val popularity: TextView =itemView.findViewById(R.id.tv_MovieRating)
    }

    fun setPostData(postList: ArrayList<Result>)
    {
        this.topRatedMoviesList=postList
        notifyDataSetChanged()
    }
}