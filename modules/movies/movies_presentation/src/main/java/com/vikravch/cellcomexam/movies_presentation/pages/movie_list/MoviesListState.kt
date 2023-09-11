package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import com.vikravch.cellcomexam.movies_domain.model.Movie

data class MoviesListState(
    val error: Throwable? = null,
    val popularFilms: List<Movie> = emptyList(),
    val favouriteMovies: List<Movie> = emptyList(),
    val broadcastFilms: List<Movie> = emptyList(),
    val popularFilmsPage: Int = 1,
    val favouriteMoviesPage: Int = 1,
    val broadcastFilmsPage: Int = 1,
)