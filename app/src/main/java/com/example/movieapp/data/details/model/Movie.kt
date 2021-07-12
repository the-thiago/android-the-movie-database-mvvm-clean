package com.example.movieapp.data.details.model

import com.br.thiago.themoviedatabaseapp.api.getdetails.Genre
import com.br.thiago.themoviedatabaseapp.api.getdetails.ProductionCompany
import com.br.thiago.themoviedatabaseapp.api.getdetails.ProductionCountry
import com.br.thiago.themoviedatabaseapp.api.getdetails.SpokenLanguage

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Long,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)