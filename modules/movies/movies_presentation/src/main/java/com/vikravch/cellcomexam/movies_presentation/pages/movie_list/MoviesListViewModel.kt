package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

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
                    state = if(res.isSuccess) {
                        state.copy(
                            popularFilms = res.getOrNull()?: emptyList(),
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }

            MoviesListEvent.LoadCurrentlyBroadcastMovies -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getCurrentlyBroadcastFilms()
                    state = if(res.isSuccess) {
                        state.copy(
                            broadcastFilms = res.getOrNull()?: emptyList(),
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }
            MoviesListEvent.LoadFavouriteMovies -> {
                viewModelScope.launch{
                    val res = moviesUseCases.getFavouriteFilms()
                    state = if(res.isSuccess) {
                        state.copy(
                            favouriteMovies = res.getOrNull()?: emptyList(),
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }
            MoviesListEvent.LoadMorePopularMovies -> {
                viewModelScope.launch{
                    val nextPage = state.popularFilmsPage + 1
                    val res = moviesUseCases.getPopularFilms(nextPage)
                    state = if(res.isSuccess) {
                        state.copy(
                            popularFilms = state.popularFilms + (res.getOrNull()?: emptyList()),
                            popularFilmsPage = nextPage,
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }
            MoviesListEvent.LoadMoreCurrentlyBroadcastMovies -> {
                viewModelScope.launch{
                    val nextPage = state.broadcastFilmsPage + 1
                    val res = moviesUseCases.getCurrentlyBroadcastFilms(nextPage)
                    state = if(res.isSuccess) {
                        state.copy(
                            broadcastFilms = state.broadcastFilms + (res.getOrNull()?: emptyList()),
                            broadcastFilmsPage = nextPage,
                            error = null
                        )
                    } else {
                        state.copy(
                            error = res.exceptionOrNull()
                        )
                    }
                }
            }

            is MoviesListEvent.ToggleFavouriteMovie -> {
                viewModelScope.launch {
                    val movie = event.movie
                    movie.isFavourite = !event.movie.isFavourite

                    val newPopularMovies = state.popularFilms.map {
                        if(it.id == event.movie.id) {
                            movie
                        } else {
                            it
                        }
                    }
                    val newBroadcastMovies = state.broadcastFilms.map {
                        if(it.id == event.movie.id) {
                            movie
                        } else {
                            it
                        }
                    }
                    val newFavouriteMovies = state.favouriteMovies.filter {
                        it.id != event.movie.id
                    }
                    state = state.copy(
                        popularFilms = newPopularMovies,
                        broadcastFilms = newBroadcastMovies,
                        favouriteMovies = newFavouriteMovies
                    )
                    moviesUseCases.markAsFavourite(movie)
                }
            }
        }
    }

}