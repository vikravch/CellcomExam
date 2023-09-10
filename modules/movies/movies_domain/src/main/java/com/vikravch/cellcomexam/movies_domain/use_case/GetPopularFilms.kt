package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class GetPopularFilms(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(): Result<List<Movie>>{
        return try {
            val favouriteFilms = moviesRepository.getPopularFilms("2c46288716a18fb7aadcc2a801f3fc6b")
            favouriteFilms
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}