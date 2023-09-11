package com.vikravch.cellcomexam.movies_presentation.pages.movie_detail

import com.vikravch.cellcomexam.movies_domain.model.Movie

data class MovieDetailsState(
    val movie: Movie? = null,
    val error: Throwable? = null,
)