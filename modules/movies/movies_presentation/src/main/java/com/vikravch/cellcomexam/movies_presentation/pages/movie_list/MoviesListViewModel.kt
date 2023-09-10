package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.vikravch.cellcomexam.movies_domain.use_case.MoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesUseCases: MoviesUseCases
): ViewModel(){

    var state: MoviesListState by mutableStateOf(MoviesListState())
        private set

    fun onEvent(event: MoviesListEvent) {
        when (event) {
            MoviesListEvent.LoadPopularMovies -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getPopularFilms()
                    if(res.isSuccess) {
                        state = state.copy(
                            movies = res.getOrNull()?: emptyList()
                        )
                        Log.d("MoviesListViewModel", "onEvent: ${state.movies}")
                    }
                }
            }

            MoviesListEvent.LoadCurrentlyBroadcastMovies -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getCurrentlyBroadcastFilms()
                    if(res.isSuccess) {
                        state = state.copy(
                            movies = res.getOrNull()?: emptyList()
                        )
                        Log.d("MoviesListViewModel", "onEvent: ${state.movies}")
                    }
                }
            }
            MoviesListEvent.LoadFavouriteMovies -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getFavouriteFilms()
                    if(res.isSuccess) {
                        state = state.copy(
                            movies = res.getOrNull()?: emptyList()
                        )
                        Log.d("MoviesListViewModel", "onEvent: ${state.movies}")
                    }
                }
            }
        }
    }

}