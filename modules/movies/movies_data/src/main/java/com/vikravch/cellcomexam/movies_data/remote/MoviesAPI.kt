package com.vikravch.cellcomexam.movies_data.remote

import com.vikravch.cellcomexam.movies_data.remote.dto.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("/3/movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String
    ): PopularMoviesDTO?

    @GET("/3/movie/now_playing")
    suspend fun getCurrentlyBroadcast(
        @Query("api_key") key: String
    ): PopularMoviesDTO?
}