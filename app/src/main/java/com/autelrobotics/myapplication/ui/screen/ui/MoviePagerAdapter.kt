package com.autelrobotics.myapplication.ui.screen.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.autelrobotics.myapplication.databinding.AdapterMovieBinding
import com.autelrobotics.myapplication.ui.screen.data.model.Movie
import com.bumptech.glide.Glide

class MoviePagerAdapter: PagingDataAdapter<Movie, MoviePagerAdapter.MovieViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)!!
        holder.view.name.text = movie.original_title
        Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w300"+movie.poster_path).into(holder.view.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    class MovieViewHolder(val view: AdapterMovieBinding): RecyclerView.ViewHolder(view.root) {

    }

    object MovieComparator: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            // Id is unique.
            return oldItem.original_title == newItem.original_title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}

