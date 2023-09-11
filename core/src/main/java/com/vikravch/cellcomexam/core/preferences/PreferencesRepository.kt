package com.vikravch.cellcomexam.core.preferences

interface PreferencesRepository {
    suspend fun markAsFavourite(id: Int, movieSerializedData: String): Result<Void?>
    suspend fun unmarkAsFavourite(id: Int, movieSerializedData: String): Result<Void?>
    suspend fun getFavouriteFilms(): Result<Set<String>>
}