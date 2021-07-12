package com.example.movieapp.domain.nowplaying.model

import com.example.movieapp.data.nowplaying.api.NowPlayingRepository

class SearchMovies(private val nowPlayingRepository: NowPlayingRepository) : SearchMoviesUseCase {
    override suspend fun invoke(query: String): List<Movie> {
        return nowPlayingRepository.searchMovies(query)
    }
}

interface SearchMoviesUseCase {
    suspend operator fun invoke(query: String): List<Movie>
}