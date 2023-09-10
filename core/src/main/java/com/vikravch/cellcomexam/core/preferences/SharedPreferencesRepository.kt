package com.vikravch.cellcomexam.core.preferences

import android.content.SharedPreferences

class SharedPreferencesRepository(
    private val sharedPreferences: SharedPreferences
): PreferencesRepository {
    override suspend fun markAsFavourite(movieId: Int): Result<Void?> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())
                ?.toMutableSet()?: mutableSetOf()
            favoriteMovies.add(movieId.toString())
            sharedPreferences.edit().putStringSet("favorite_movies", favoriteMovies).apply()
            Result.success(null)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun unmarkAsFavourite(movieId: Int): Result<Void?> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())
                ?.toMutableSet()?: mutableSetOf()
            favoriteMovies.remove(movieId.toString())
            sharedPreferences.edit().putStringSet("favorite_movies", favoriteMovies).apply()
            Result.success(null)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFavouriteFilms(): Result<Set<Int>> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())?.map{
                it.toInt()
            }?.toMutableSet()?: mutableSetOf()
            Result.success(favoriteMovies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}