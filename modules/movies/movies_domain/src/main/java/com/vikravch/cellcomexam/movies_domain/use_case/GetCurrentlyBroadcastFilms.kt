package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.core.BuildConfig
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetCurrentlyBroadcastFilms(
    private val moviesRepository: MoviesRepository,
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(page: Int = 1): Result<List<Movie>>{
        return try {
            val currentlyBroadcastFilms = moviesRepository.getCurrentlyBroadcastFilms(
                BuildConfig.API_KEY, page)
            val favouriteFilms = preferencesRepository.getFavouriteFilms().getOrNull()?.map {
                Movie.fromJSON(it)
            }?: emptyList()
            currentlyBroadcastFilms.getOrNull()?.map {
                it.isFavourite = favouriteFilms.contains(it)
                it
            }?.let {
                Result.success(it)
            }?: run {
                Result.failure(Exception("Something went wrong"))
            }
            //currentlyBroadcastFilms
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}