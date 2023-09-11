package com.vikravch.cellcomexam.movies_presentation.pages.movie_detail

import com.vikravch.cellcomexam.movies_domain.model.Movie

sealed class MovieDetailsEvent {
    data class LoadMovieDetails(val id: Int) : MovieDetailsEvent()
    data class ToggleFavourite(val movie: Movie) : MovieDetailsEvent()
}