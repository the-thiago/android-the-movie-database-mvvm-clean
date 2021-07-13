package com.example.movieapp.domain.favorites

import com.example.movieapp.data.favorites.local.LocalMoviesRepository
import com.example.movieapp.domain.favorites.model.LocalMovieDomain

class GetLocalMovies(
    private val repository: LocalMoviesRepository
) : GetLocalMoviesUseCase {
    override suspend fun invoke(): List<LocalMovieDomain> {
        return repository.getLocalMovies()
    }
}

interface GetLocalMoviesUseCase {
    suspend operator fun invoke(): List<LocalMovieDomain>
}