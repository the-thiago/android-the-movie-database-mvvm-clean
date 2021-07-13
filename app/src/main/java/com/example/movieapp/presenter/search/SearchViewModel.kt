package com.example.movieapp.presenter.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.nowplaying.SearchMoviesUseCase
import com.example.movieapp.presenter.nowplaying.model.MovieUiModel
import com.example.movieapp.presenter.nowplaying.model.toUiModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieUiModel>>()
    val movies = _movies as LiveData<List<MovieUiModel>>
    private var job: Job? = null

    fun searchMovies(query: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(400L)
            _movies.value = searchMoviesUseCase.invoke(query).map { it.toUiModel() }
        }
    }

}