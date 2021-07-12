package com.example.movieapp.data.nowplaying.model

data class NowPlayingMoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)