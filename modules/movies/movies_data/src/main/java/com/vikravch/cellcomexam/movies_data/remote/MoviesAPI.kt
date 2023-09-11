package com.vikravch.cellcomexam.movies_data.remote

import com.vikravch.cellcomexam.movies_data.remote.dto.MovieDTO
import com.vikravch.cellcomexam.movies_data.remote.dto.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    @GET("/3/movie/popular")
    suspend fun getPopular(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): PopularMoviesDTO?

    @GET("/3/movie/now_playing")
    suspend fun getCurrentlyBroadcast(
        @Query("api_key") key: String,
        @Query("page") page: Int = 1
    ): PopularMoviesDTO?

    @GET("/3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Query("api_key") key: String,
    ): MovieDTO?
}