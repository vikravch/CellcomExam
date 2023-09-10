package com.vikravch.cellcomexam.movies_data.repository

import android.util.Log
import com.vikravch.cellcomexam.core.NoInternetException
import com.vikravch.cellcomexam.core.ServerException
import com.vikravch.cellcomexam.core.network.NetworkInfo
import com.vikravch.cellcomexam.movies_data.remote.MoviesAPI
import com.vikravch.cellcomexam.movies_data.toMovie
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val moviesApi: MoviesAPI,
    private val networkInfo: NetworkInfo
): MoviesRepository {

    override suspend fun getPopularFilms(key: String): Result<List<Movie>> {
        return if (networkInfo.isConnected()) {
            try {
                val response = moviesApi.getPopular(key)
                Result.success(response?.results?.map { it.toMovie() }?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(ServerException(e.message?:""))
            }
        } else {
            Result.failure(NoInternetException())
        }
    }

    override suspend fun getCurrentlyBroadcastFilms(key: String): Result<List<Movie>> {
        return if (networkInfo.isConnected()) {
            try {
                val response = moviesApi.getCurrentlyBroadcast(key)
                Result.success(response?.results?.map { it.toMovie() }?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(ServerException(e.message?:""))
            }
        } else {
            Result.failure(NoInternetException())
        }
    }
}