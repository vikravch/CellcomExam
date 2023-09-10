package com.vikravch.cellcomexam.movies_domain.use_case

import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.model.Movie

class ToggleFavourite(
    private val preferencesRepository: PreferencesRepository
) {

    suspend operator fun invoke(movie: Movie): Result<Void?> {
        return if(movie.isFavourite)
            preferencesRepository.markAsFavourite(movie.id)
        else preferencesRepository.unmarkAsFavourite(movie.id)
    }
}