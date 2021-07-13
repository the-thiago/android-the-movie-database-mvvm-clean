package com.example.movieapp

import android.app.Application
import androidx.room.Room
import com.example.movieapp.data.Service
import com.example.movieapp.data.details.api.DetailsRepository
import com.example.movieapp.data.details.api.DetailsRepositoryImpl
import com.example.movieapp.data.details.api.MovieDetailsApi
import com.example.movieapp.data.favorites.local.LocalMovieDao
import com.example.movieapp.data.favorites.local.LocalMoviesRepository
import com.example.movieapp.data.favorites.local.LocalMoviesRepositoryImpl
import com.example.movieapp.data.favorites.local.MovieDatabase
import com.example.movieapp.data.nowplaying.api.NowPlayingApi
import com.example.movieapp.data.nowplaying.api.NowPlayingRepository
import com.example.movieapp.data.nowplaying.api.NowPlayingRepositoryImpl
import com.example.movieapp.domain.details.GetMovieDetails
import com.example.movieapp.domain.details.GetMovieDetailsUseCase
import com.example.movieapp.domain.favorites.GetLocalMovies
import com.example.movieapp.domain.favorites.GetLocalMoviesUseCase
import com.example.movieapp.domain.nowplaying.GetNowPlayingMovies
import com.example.movieapp.domain.nowplaying.GetNowPlayingMoviesUseCase
import com.example.movieapp.domain.nowplaying.model.SearchMovies
import com.example.movieapp.domain.nowplaying.model.SearchMoviesUseCase
import com.example.movieapp.presenter.details.DetailsViewModel
import com.example.movieapp.presenter.favorites.FavoritesViewModel
import com.example.movieapp.presenter.nowplaying.NowPlayingViewModel
import com.example.movieapp.presenter.search.SearchViewModel
import org.koin.android.ext.koin.androidApplication
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
    single { Service().createService(MovieDetailsApi::class.java) }

    single<DetailsRepository> { DetailsRepositoryImpl(get()) }

    single<GetMovieDetailsUseCase> { GetMovieDetails(get()) }

    viewModel {
        DetailsViewModel(get())
    }
}

val searchMoviesModule = module {
    single<SearchMoviesUseCase> { SearchMovies(get()) }

    viewModel {
        SearchViewModel(get())
    }
}

val favoritesMoviesModule = module {
    single { provideDatabase(androidApplication()) }

    single { provideMoviesDao(get()) }

    single<LocalMoviesRepository> { LocalMoviesRepositoryImpl(get()) }

    single<GetLocalMoviesUseCase> { GetLocalMovies(get()) }

    viewModel {
        FavoritesViewModel(get())
    }
}

fun provideDatabase(androidApplication: Application): MovieDatabase {
    return Room.databaseBuilder(
        androidApplication,
        MovieDatabase::class.java,
        "movie_db.db"
    ).build()
}

fun provideMoviesDao(database: MovieDatabase): LocalMovieDao {
    return database.getMovieDao()
}