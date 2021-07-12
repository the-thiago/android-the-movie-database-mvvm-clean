package com.example.movieapp.domain.details

import com.example.movieapp.data.details.api.DetailsRepository
import com.example.movieapp.domain.details.model.MovieDetails

class GetMovieDetails(
    private val repository: DetailsRepository
) : GetMovieDetailsUseCase {

    override suspend fun invoke(movieId: Int): MovieDetails? = try {
        repository.getMovieDetails(movieId)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

}

interface GetMovieDetailsUseCase {
    suspend operator fun invoke(movieId: Int): MovieDetails?
}