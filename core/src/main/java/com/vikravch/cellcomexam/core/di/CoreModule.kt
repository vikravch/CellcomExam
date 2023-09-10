package com.vikravch.cellcomexam.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.vikravch.cellcomexam.core.network.NetworkInfo
import com.vikravch.cellcomexam.core.network.NetworkInfoImpl
import com.vikravch.cellcomexam.core.preferences.PreferencesRepository
import com.vikravch.cellcomexam.core.preferences.SharedPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideNetworkInfo(@ApplicationContext context: Context): NetworkInfo {
        return NetworkInfoImpl(context)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): PreferencesRepository {
        return SharedPreferencesRepository(sharedPreferences)
    }
}