package com.example.movieapp.data.details.api

import com.example.movieapp.data.details.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("movie/{id}?$KEY_AND_LANGUAGE")
    suspend fun getMovieDetails(@Path("id") movieId: Int): Response<Movie>

    companion object {
        private const val KEY = "f0ddbdbd9b527dc41f8f2c75c7e901f1"
        private const val LANGUAGE = "en-US"
        private const val KEY_AND_LANGUAGE = "api_key=$KEY&language=$LANGUAGE"
    }
}