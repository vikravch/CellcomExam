package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.core.BuildConfig
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetMovieDetails(
    private val moviesRepository: MoviesRepository,
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(id: Int):Result<Movie?> {
        val favouriteFilms = preferencesRepository.getFavouriteFilms().getOrNull()?.map {
            Movie.fromJSON(it)
        }
        val movie = moviesRepository.getMovieDetails(BuildConfig.API_KEY, id).getOrNull()?.apply {
            this.isFavourite = favouriteFilms?.contains(this) ?: false
        }
        return Result.success(movie)
    }
}