package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

sealed class MoviesListEvent {

    object LoadPopularMovies : MoviesListEvent()
    object LoadFavouriteMovies : MoviesListEvent()
    object LoadCurrentlyBroadcastMovies : MoviesListEvent()
}