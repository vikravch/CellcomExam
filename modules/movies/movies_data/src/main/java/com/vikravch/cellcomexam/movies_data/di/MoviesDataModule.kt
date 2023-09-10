package com.vikravch.cellcomexam.movies_data.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.vikravch.cellcomexam.core.BASE_URL
import com.vikravch.cellcomexam.core.network.NetworkInfo
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.movies_data.remote.MoviesAPI
import com.vikravch.cellcomexam.movies_data.repository.MoviesRepositoryImpl
import com.vikravch.cellcomexam.movies_domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(appPreferencesRepository: PreferencesRepository): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor {
                        message -> Log.d("cellcom_api", message)
                }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesApi(client: OkHttpClient): MoviesAPI {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        val gson = gsonBuilder.create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(MoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(
        api: MoviesAPI,
        networkInfo: NetworkInfo
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            moviesApi = api,
            networkInfo = networkInfo
        )
    }
}