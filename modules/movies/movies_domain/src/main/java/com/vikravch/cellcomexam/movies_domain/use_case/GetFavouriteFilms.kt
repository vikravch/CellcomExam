package com.vikravch.cellcomexam.movies_domain.use_case

import android.util.Log
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetFavouriteFilms(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(): Result<List<Movie>>{
        return try {
            val res = preferencesRepository.getFavouriteFilms().getOrNull()?.map {
                Movie.fromJSON(it)
            }?: emptyList()
            Log.d("GetFavouriteFilms", "res: $res")
            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}