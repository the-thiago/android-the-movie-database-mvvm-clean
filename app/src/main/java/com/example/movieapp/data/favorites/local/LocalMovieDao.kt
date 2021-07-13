package com.example.movieapp.data.favorites.local

import androidx.room.*
import com.example.movieapp.data.favorites.model.LocalMovie

@Dao
interface LocalMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: LocalMovie): Long

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<LocalMovie>

    @Delete
    suspend fun deleteMovie(movie: LocalMovie)
}