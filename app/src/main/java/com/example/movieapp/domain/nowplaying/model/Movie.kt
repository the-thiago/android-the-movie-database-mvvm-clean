package com.example.movieapp.domain.nowplaying.model

data class Movie(
    val id: Int,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val voteAverage: Double?,
)