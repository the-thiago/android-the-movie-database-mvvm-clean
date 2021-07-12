package com.example.movieapp.domain.nowplaying.model

data class Movie(
    val backdropPath: String,
    val id: Int,
    val originalTitle: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)