package com.example.movieapp.domain.nowplaying

import com.example.movieapp.data.nowplaying.api.NowPlayingRepository
import com.example.movieapp.domain.nowplaying.model.Movie

class GetNowPlayingMovies(
    private val nowPlayingRepository: NowPlayingRepository
) : GetNowPlayingMoviesUseCase {

    override suspend fun invoke(moviesPage: Int): List<Movie> = try {
        nowPlayingRepository.getNowPlayingMovies(moviesPage)
    } catch (exception: Exception) {
        listOf()
    }

}

interface GetNowPlayingMoviesUseCase {
    suspend operator fun invoke(moviesPage: Int): List<Movie>
}