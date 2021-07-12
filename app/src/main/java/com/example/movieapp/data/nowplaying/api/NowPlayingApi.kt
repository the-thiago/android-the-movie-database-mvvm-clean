package com.example.movieapp.data.nowplaying.api

import com.example.movieapp.data.nowplaying.model.NowPlayingMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NowPlayingApi {
    @GET(GET_MOVIES_URL)
    suspend fun getMovies(@Query("page") page: Int): Response<NowPlayingMoviesResponse>

    @GET(SEARCH_MOVIES_URL)
    suspend fun searchMovies(@Query("query") query: String): Response<NowPlayingMoviesResponse>

    companion object {
        private const val KEY = "f0ddbdbd9b527dc41f8f2c75c7e901f1"
        private const val LANGUAGE = "en-US"
        private const val KEY_AND_LANGUAGE = "api_key=$KEY&language=$LANGUAGE"
        private const val GET_MOVIES_URL = "movie/now_playing?$KEY_AND_LANGUAGE"
        private const val SEARCH_MOVIES_URL = "search/movie?api_key=$KEY"
    }
}