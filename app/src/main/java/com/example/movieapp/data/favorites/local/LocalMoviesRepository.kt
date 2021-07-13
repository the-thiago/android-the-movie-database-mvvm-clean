package com.example.movieapp.data.favorites.local

import com.example.movieapp.domain.favorites.model.LocalMovieDomain
import com.example.movieapp.domain.favorites.model.toLocalMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalMoviesRepositoryImpl(
    private val localMovieDao: LocalMovieDao
) : LocalMoviesRepository {
    override suspend fun getLocalMovies(): List<LocalMovieDomain> = withContext(Dispatchers.IO) {
        return@withContext localMovieDao.getAllMovies().map { it.toLocalMovie() }
    }
}

interface LocalMoviesRepository {
    suspend fun getLocalMovies(): List<LocalMovieDomain>
}