package com.example.movieapp

import com.example.movieapp.data.Service
import com.example.movieapp.data.details.api.DetailsApi
import com.example.movieapp.data.details.api.DetailsRepository
import com.example.movieapp.data.details.api.DetailsRepositoryImpl
import com.example.movieapp.data.nowplaying.api.NowPlayingApi
import com.example.movieapp.data.nowplaying.api.NowPlayingRepository
import com.example.movieapp.data.nowplaying.api.NowPlayingRepositoryImpl
import com.example.movieapp.domain.details.GetMovieDetails
import com.example.movieapp.domain.details.GetMovieDetailsUseCase
import com.example.movieapp.domain.nowplaying.GetNowPlayingMovies
import com.example.movieapp.domain.nowplaying.GetNowPlayingMoviesUseCase
import com.example.movieapp.presenter.details.DetailsViewModel
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

val movieDetailsModule = module {
    single { Service().createService(DetailsApi::class.java) }

    single<DetailsRepository> { DetailsRepositoryImpl(get()) }

    single<GetMovieDetailsUseCase> { GetMovieDetails(get()) }

    viewModel {
        DetailsViewModel(get())
    }
}