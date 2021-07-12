package com.example.movieapp

import com.example.movieapp.data.Service
import com.example.movieapp.data.nowplaying.api.NowPlayingApi
import com.example.movieapp.data.nowplaying.api.NowPlayingRepository
import com.example.movieapp.data.nowplaying.api.NowPlayingRepositoryImpl
import com.example.movieapp.domain.nowplaying.GetNowPlayingMovies
import com.example.movieapp.domain.nowplaying.GetNowPlayingMoviesUseCase
import com.example.movieapp.presenter.nowplaying.NowPlayingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nowPlayingMoviesModule = module {
    single { Service().createService(NowPlayingApi::class.java) }

    single<NowPlayingRepository> { NowPlayingRepositoryImpl(get()) }

    single<GetNowPlayingMoviesUseCase> { GetNowPlayingMovies(get()) }

    viewModel {
        NowPlayingViewModel(get())
    }
}