package com.example.movieapp.presenter.details.model

import com.example.movieapp.domain.details.model.MovieDetails

data class MovieDetailsUiModel(
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

fun MovieDetails.toUiModel() = MovieDetailsUiModel(
    id = this.id,
    backdropPath = this.backdropPath,
    posterPath = this.posterPath,
    title = this.title,
    budget = this.budget,
    overview = this.overview,
    releaseDate = this.releaseDate,
    status = this.status,
    revenue = this.revenue,
    originalTitle = this.originalTitle,
    runtime = this.runtime,
    voteAverage = this.voteAverage
)