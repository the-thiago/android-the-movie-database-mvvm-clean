package com.example.movieapp.data

import com.example.movieapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"
const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

class Service {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().addInterceptor(logInterceptor()).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }

    private fun logInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

}