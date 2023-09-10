package com.vikravch.cellcomexam.movies_data

import com.vikravch.cellcomexam.movies_data.remote.dto.MovieDTO
import com.vikravch.cellcomexam.movies_domain.model.Movie

fun MovieDTO.toMovie(): Movie{
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        popularity = popularity,
        adult = adult,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        genreIds = genreIds
    )
}