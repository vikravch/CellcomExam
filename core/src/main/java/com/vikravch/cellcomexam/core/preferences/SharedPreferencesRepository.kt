package com.vikravch.cellcomexam.core.preferences

import android.content.SharedPreferences
import android.util.Log

class SharedPreferencesRepository(
    private val sharedPreferences: SharedPreferences
): PreferencesRepository {
    override suspend fun markAsFavourite(id: Int, movieSerializedData: String): Result<Void?> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())
                ?.toMutableSet()?: mutableSetOf()
            favoriteMovies.add(id.toString())
            sharedPreferences.edit().putStringSet("favorite_movies", favoriteMovies).apply()
            sharedPreferences.edit().putString("movie_${id}", movieSerializedData).apply()
            Result.success(null)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun unmarkAsFavourite(id: Int, movieSerializedData: String): Result<Void?> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())
                ?.toMutableSet()?: mutableSetOf()
            favoriteMovies.remove(id.toString())
            sharedPreferences.edit().putStringSet("favorite_movies", favoriteMovies).apply()
            sharedPreferences.edit().remove("movie_${id}").apply()
            Result.success(null)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFavouriteFilms(): Result<Set<String>> {
        return try {
            val favoriteMovies = sharedPreferences.getStringSet("favorite_movies", mutableSetOf())
                ?.toMutableSet()?: mutableSetOf()
            Result.success(favoriteMovies.map {
                sharedPreferences.getString("movie_${it}", "")?: ""
            }.toSet())

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}