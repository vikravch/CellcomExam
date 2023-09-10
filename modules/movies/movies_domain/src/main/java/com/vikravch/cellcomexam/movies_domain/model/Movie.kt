package com.vikravch.cellcomexam.movies_domain.model

class Movie (
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavourite: Boolean = false
){
    override fun toString(): String {
        return "Movie(adult=$adult, backdropPath='$backdropPath', genreIds=$genreIds, id=$id, originalLanguage='$originalLanguage', originalTitle='$originalTitle', overview='$overview', popularity=$popularity, posterPath='$posterPath', releaseDate='$releaseDate', title='$title', video=$video, voteAverage=$voteAverage, voteCount=$voteCount, isFavourite=$isFavourite)"
    }
}

/*
{
            "adult": false,
            "backdrop_path": "/8pjWz2lt29KyVGoq1mXYu6Br7dE.jpg",
            "genre_ids": [
                28,
                878,
                27
            ],
            "id": 615656,
            "original_language": "en",
            "original_title": "Meg 2: The Trench",
            "overview": "An exploratory dive into the deepest depths of the ocean of a daring research team spirals into chaos when a malevolent mining operation threatens their mission and forces them into a high-stakes battle for survival.",
            "popularity": 4372.097,
            "poster_path": "/4m1Au3YkjqsxF8iwQy0fPYSxE0h.jpg",
            "release_date": "2023-08-02",
            "title": "Meg 2: The Trench",
            "video": false,
            "vote_average": 7,
            "vote_count": 1563
        }
 */