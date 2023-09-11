package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import com.vikravch.cellcomexam.core_ui.components.FilterMode
import com.vikravch.cellcomexam.movies_domain.model.Movie

sealed class MoviesListEvent {

    object LoadPopularMovies : MoviesListEvent()
    object LoadFavouriteMovies : MoviesListEvent()
    object LoadCurrentlyBroadcastMovies : MoviesListEvent()
    object LoadMorePopularMovies : MoviesListEvent()
    object LoadMoreCurrentlyBroadcastMovies : MoviesListEvent()
    data class ToggleFavouriteMovie(val movie: Movie, val filterStatus: FilterMode) : MoviesListEvent()
}