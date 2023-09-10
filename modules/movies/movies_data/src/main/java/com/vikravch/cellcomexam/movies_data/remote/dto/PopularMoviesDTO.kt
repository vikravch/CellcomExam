package com.vikravch.cellcomexam.movies_data.remote.dto

import com.google.gson.annotations.SerializedName

class PopularMoviesDTO(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDTO>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int,
)