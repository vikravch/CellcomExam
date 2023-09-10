package com.vikravch.cellcomexam.movies_domain.repository

import com.vikravch.cellcomexam.movies_domain.model.Movie

interface MoviesRepository {
    suspend fun getPopularFilms(key: String): Result<List<Movie>>
    suspend fun getCurrentlyBroadcastFilms(key: String): Result<List<Movie>>
}