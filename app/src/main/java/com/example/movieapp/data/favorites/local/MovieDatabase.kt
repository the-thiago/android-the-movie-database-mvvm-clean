package com.example.movieapp.data.favorites.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.favorites.model.LocalMovie

@Database(
    entities = [LocalMovie::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): LocalMovieDao
}