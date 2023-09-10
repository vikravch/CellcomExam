package com.vikravch.cellcomexam.core.preferences

interface PreferencesRepository {
    suspend fun markAsFavourite(movieId: Int): Result<Void?>
    suspend fun unmarkAsFavourite(movieId: Int): Result<Void?>
    suspend fun getFavouriteFilms(): Result<Set<Int>>
}