package com.example.movieapp.domain.favorites.model

import com.example.movieapp.data.favorites.model.LocalMovie

class LocalMovieDomain(
    val id: Int,
    val backdropPath: String?,
    val posterPath: String?,
    val title: String?,
    val budget: Long?,
    val overview: String?,
    val releaseDate: String?,
    val status: String?,
    val revenue: Long?,
    val originalTitle: String?,
    val runtime: Int?,
    val voteAverage: Double?
)

fun LocalMovie.toLocalMovie() = LocalMovieDomain(
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