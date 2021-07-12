package com.example.movieapp.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.BASE_IMAGE_URL
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel

class MovieAdapter(
    private val callback: (MovieUiModel) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<MovieUiModel>() {
        override fun areItemsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun setItems(list: List<MovieUiModel>) {
        differ.submitList(differ.currentList + list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivImageMovie: ImageView = itemView.findViewById(R.id.ivImageMovie)
        private val tvMovieTitle: TextView = itemView.findViewById(R.id.tvMovieTitle)
        private val tvReleaseDate: TextView = itemView.findViewById(R.id.tvReleaseDate)
        private val tvVoteAverage: TextView = itemView.findViewById(R.id.tvVoteAverage)

        fun bind(movie: MovieUiModel) {
            tvMovieTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate.replace("-", "/")
            tvVoteAverage.text = movie.voteAverage.toString()
            itemView.setOnClickListener { callback.invoke(movie) }

            Glide.with(itemView)
                .load("${BASE_IMAGE_URL}${movie.posterPath}")
                .placeholder(R.drawable.ic_movie_image_placeholder)
                .centerCrop()
                .into(ivImageMovie)
        }
    }
}