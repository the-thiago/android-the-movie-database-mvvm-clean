package com.example.movieapp.presenter.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.favorites.GetLocalMoviesUseCase
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel
import com.example.movieapp.presenter.nowplaying.model.toUiModel
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getLocalMovies: GetLocalMoviesUseCase
) : ViewModel() {

    private val _favoriteMovies = MutableLiveData<List<MovieUiModel>>()
    val favoriteMovies = _favoriteMovies as LiveData<List<MovieUiModel>>

    fun getLocalMovies() {
        viewModelScope.launch {
            _favoriteMovies.postValue(getLocalMovies.invoke().map { it.toUiModel() })
        }
    }

}