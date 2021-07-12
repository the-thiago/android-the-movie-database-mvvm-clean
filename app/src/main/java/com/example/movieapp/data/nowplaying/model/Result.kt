package com.example.movieapp.data.nowplaying.model

import com.example.movieapp.domain.nowplaying.model.Movie

data class Result(
    val backdrop_path: String,
    val id: Int,
    val original_title: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)

fun Result.toMovie() = Movie(
    id = this.id,
    posterPath = this.poster_path,
    releaseDate = this.release_date,
    title = this.title,
    voteAverage = this.vote_average
)