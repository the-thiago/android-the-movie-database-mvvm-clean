package com.example.movieapp.presenter.nowplaying.model

import com.example.movieapp.data.nowplaying.model.toMovie
import com.example.movieapp.domain.nowplaying.model.Movie

class MovieUiModel(
    val backdropPath: String,
    val id: Int,
    val originalTitle: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)

fun Movie.toUiModel() = MovieUiModel(
    backdropPath = this.backdropPath,
    id = this.id,
    originalTitle = this.originalTitle,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    voteAverage = this.voteAverage
)