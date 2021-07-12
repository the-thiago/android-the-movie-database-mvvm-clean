package com.example.movieapp.presenter.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.nowplaying.GetNowPlayingMoviesUseCase
import com.example.movieapp.domain.nowplaying.model.Movie
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel
import com.example.movieapp.presenter.nowplaying.model.toUiModel
import kotlinx.coroutines.launch

class NowPlayingViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<MovieUiModel>>()
    val nowPlayingMovies = _nowPlayingMovies as LiveData<List<MovieUiModel>>

    private var moviesPage = 1

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            val moviesList: List<Movie> = getNowPlayingMoviesUseCase(moviesPage)
            moviesPage++
            _nowPlayingMovies.value = moviesList.map { movie ->
                movie.toUiModel()
            }
        }
    }

}