package com.vikravch.cellcomexam.movies_domain.use_case

import android.util.Log
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository
import com.vikravch.cellcomexam.core.BuildConfig

class GetPopularFilms(
    private val moviesRepository: MoviesRepository,
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(page: Int = 1): Result<List<Movie>>{
        return try {
            val popularFilms = moviesRepository.getPopularFilms(BuildConfig.API_KEY, page).getOrNull()
            val favouriteFilms = preferencesRepository.getFavouriteFilms().getOrNull()?.map {
                Movie.fromJSON(it)
            }?: emptyList()
            Result.success(popularFilms?.map {
                it.isFavourite = favouriteFilms.contains(it)
                it
            }?: emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}