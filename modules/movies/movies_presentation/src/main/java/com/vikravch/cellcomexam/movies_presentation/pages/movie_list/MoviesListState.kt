package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import com.vikravch.cellcomexam.movies_domain.model.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: Throwable? = null
)