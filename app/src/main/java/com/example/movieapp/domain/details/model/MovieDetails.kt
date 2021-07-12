package com.example.movieapp.domain.details.model

import com.example.movieapp.data.details.model.Movie

data class MovieDetails(
    val id: Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val budget: Long,
    val overview: String,
    val releaseDate: String,
    val status: String,
    val revenue: Long,
    val originalTitle: String,
    val runtime: Int,
    val voteAverage: Double
)

fun Movie.toMovieDetails() = MovieDetails(
    id = this.id,
    backdropPath = this.backdrop_path,
    posterPath = this.poster_path,
    title = this.title,
    budget = this.budget,
    overview = this.overview,
    releaseDate = this.release_date,
    status = this.status,
    revenue = this.revenue,
    originalTitle = this.original_title,
    runtime = this.runtime,
    voteAverage = this.vote_average
)