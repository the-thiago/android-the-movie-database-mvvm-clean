package com.example.movieapp.domain.nowplaying

import com.example.movieapp.data.nowplaying.api.NowPlayingRepository
import com.example.movieapp.domain.nowplaying.model.Movie

class SearchMovies(private val nowPlayingRepository: NowPlayingRepository) : SearchMoviesUseCase {
    override suspend fun invoke(query: String): List<Movie> {
        return nowPlayingRepository.searchMovies(query)
    }
}

interface SearchMoviesUseCase {
    suspend operator fun invoke(query: String): List<Movie>
}