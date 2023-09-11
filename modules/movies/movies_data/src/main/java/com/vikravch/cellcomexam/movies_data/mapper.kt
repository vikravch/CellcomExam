package com.vikravch.cellcomexam.movies_data

import com.vikravch.cellcomexam.movies_data.remote.dto.MovieDTO
import com.vikravch.cellcomexam.movies_domain.model.Movie

fun MovieDTO.toMovie(): Movie{
    return Movie(
        id = id,
        title = title?:"No title",
        overview = overview?:"No overview",
        posterPath = posterPath?: "",
        backdropPath = backdropPath?: "",
        releaseDate = releaseDate?:"No release date",
        voteAverage = voteAverage?: 0.0,
        voteCount = voteCount?: 0,
        popularity = popularity?: 0.0,
        adult = adult?: false,
        originalLanguage = originalLanguage?:"No original language",
        originalTitle = originalTitle?:"No original title",
        video = video?: false,
        genreIds = genreIds?: listOf()
    )
}