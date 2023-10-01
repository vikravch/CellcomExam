package com.vikravch.cellcomexam.movies_presentation.pages.movie_detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.use_case.MoviesUseCases
import com.vikravch.cellcomexam.movies_presentation.pages.movie_list.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesUseCases: MoviesUseCases
): ViewModel() {

    var state: MovieDetailsState by mutableStateOf(MovieDetailsState())
        private set

    fun onEvent(event: MovieDetailsEvent){
        when(event){
            is MovieDetailsEvent.LoadMovieDetails -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getMovieDetails(event.id)
                    state = if(res.isSuccess){
                        state.copy(
                            movie = res.getOrNull(),
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }
            is MovieDetailsEvent.ToggleFavourite -> {
                viewModelScope.launch{
                    state = state.copy(
                        movie = null,
                        error = null
                    )
                    val newMovie = event.movie.copy(isFavourite = (!event.movie.isFavourite))
                    moviesUseCases.markAsFavourite(newMovie)
                    state = state.copy(
                        movie = newMovie,
                        error = null
                    )
                }
            }
        }
    }
}