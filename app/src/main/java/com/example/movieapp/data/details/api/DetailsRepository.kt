package com.example.movieapp.data.details.api

import com.example.movieapp.domain.details.model.MovieDetails
import com.example.movieapp.domain.details.model.toMovieDetails

class DetailsRepositoryImpl(private val service: MovieDetailsApi) : DetailsRepository {
    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val result = service.getMovieDetails(movieId)
        if (result.isSuccessful) {
            result.body()?.let {
                return it.toMovieDetails()
            }
        }
        throw GetMovieDetailsException()
    }
}

interface DetailsRepository {
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}

class GetMovieDetailsException : Exception()