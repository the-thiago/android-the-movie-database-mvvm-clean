package com.example.movieapp.data.nowplaying.api

import com.example.movieapp.data.nowplaying.model.toMovie
import com.example.movieapp.domain.nowplaying.model.Movie

class NowPlayingRepositoryImpl(
    private val service: NowPlayingApi
) : NowPlayingRepository {
    override suspend fun getNowPlayingMovies(moviesPage: Int): List<Movie> {
        val result = service.getMovies(moviesPage)
        if (result.isSuccessful) {
            val body = result.body()

            if (body != null) {
                return body.results.map {
                    it.toMovie()
                }
            }
        }
        throw GetNowPlayingMoviesException()
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        val result = service.searchMovies(query)
        if (result.isSuccessful) {
            val body = result.body()

            if (body != null) {
                return body.results.map {
                    it.toMovie()
                }
            }
        }
        return listOf()
    }
}

interface NowPlayingRepository {
    suspend fun getNowPlayingMovies(moviesPage: Int): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
}

class GetNowPlayingMoviesException : Exception()