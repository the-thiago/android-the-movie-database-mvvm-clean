package com.example.movieapp.presenter.nowplaying.model

import com.example.movieapp.domain.favorites.model.LocalMovieDomain
import com.example.movieapp.domain.nowplaying.model.Movie

data class MovieUiModel(
    val id: Int,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)

fun Movie.toUiModel() = MovieUiModel(
    id = this.id,
    posterPath = this.posterPath ?: "",
    releaseDate = this.releaseDate ?: "",
    title = this.title ?: "",
    voteAverage = this.voteAverage ?: 0.0
)

fun LocalMovieDomain.toUiModel() = MovieUiModel(
    id = this.id,
    posterPath = this.posterPath ?: "",
    releaseDate = this.releaseDate ?: "",
    title = this.title ?: "",
    voteAverage = this.voteAverage ?: 0.0
)