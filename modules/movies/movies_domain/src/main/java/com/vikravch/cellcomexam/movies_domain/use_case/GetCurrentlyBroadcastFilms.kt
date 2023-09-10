package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetCurrentlyBroadcastFilms(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(): Result<List<Movie>>{
        return try {
            val currentlyBroadcastFilms = moviesRepository.getCurrentlyBroadcastFilms("2c46288716a18fb7aadcc2a801f3fc6b")
            currentlyBroadcastFilms
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}