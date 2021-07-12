package com.example.movieapp.presenter.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.details.GetMovieDetailsUseCase
import com.example.movieapp.presenter.details.model.MovieDetailsUiModel
import com.example.movieapp.presenter.details.model.toUiModel
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetailsUiModel?>()
    val movieDetails = _movieDetails as LiveData<MovieDetailsUiModel?>

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetails.value = getMovieDetailsUseCase.invoke(movieId)?.toUiModel()
        }
    }
}