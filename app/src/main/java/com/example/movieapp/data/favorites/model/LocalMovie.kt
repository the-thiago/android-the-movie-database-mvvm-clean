package com.example.movieapp.data.favorites.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class LocalMovie(
    @PrimaryKey(autoGenerate = false)
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