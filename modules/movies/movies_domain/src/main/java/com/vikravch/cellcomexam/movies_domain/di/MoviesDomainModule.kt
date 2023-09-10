package com.vikravch.cellcomexam.movies_domain.di

import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository
import com.vikravch.cellcomexam.movies_domain.use_case.GetCurrentlyBroadcastFilms
import com.vikravch.cellcomexam.movies_domain.use_case.GetFavouriteFilms
import com.vikravch.cellcomexam.movies_domain.use_case.GetPopularFilms
import com.vikravch.cellcomexam.movies_domain.use_case.ToggleFavourite
import com.vikravch.cellcomexam.movies_domain.use_case.MoviesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesDomainModule {

    @Provides
    @Singleton
    fun provideMoviesUseCases(
        repository: MoviesRepository,
        preferencesRepository: PreferencesRepository
    ): MoviesUseCases {
        return MoviesUseCases(
            getPopularFilms = GetPopularFilms(repository),
            markAsFavourite = ToggleFavourite(preferencesRepository),
            getFavouriteFilms = GetFavouriteFilms(repository, preferencesRepository),
            getCurrentlyBroadcastFilms = GetCurrentlyBroadcastFilms(repository)
        )
    }
}