package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetFavouriteFilms(
    private val moviesRepository: MoviesRepository,
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(): Result<List<Movie>>{
        return try {
            val favouriteFilms = moviesRepository.getPopularFilms("2c46288716a18fb7aadcc2a801f3fc6b")
            val favouriteFilmsIds = preferencesRepository.getFavouriteFilms()
            Result.success(favouriteFilms.getOrNull()?.filter {
                favouriteFilmsIds.getOrNull()?.contains(it.id)?:false
            }?: emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}