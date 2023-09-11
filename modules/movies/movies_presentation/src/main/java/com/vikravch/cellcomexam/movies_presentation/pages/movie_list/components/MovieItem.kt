package com.vikravch.cellcomexam.movies_presentation.pages.movie_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vikravch.cellcomexam.movies_domain.model.Movie
import com.vikravch.cellcomexam.movies_domain.use_case.ToggleFavourite

@Composable
fun MovieItem(
    movie: Movie,
    onSelectMovie: (Int) -> Unit,
    toggleFavourite: (Movie) -> Unit
) {
    val painter =
        rememberImagePainter(data = "https://image.tmdb.org/t/p/w500${movie.backdropPath}")

    Row(modifier = Modifier.fillMaxWidth().clickable {
        onSelectMovie(movie.id)
    }) {
        Image(
            painter = painter,
            contentDescription = "Backdrop image",
            modifier = Modifier
                .height(140.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = movie.title)
            Text(text = if(movie.overview.length>=100)
                "${movie.overview.substring(0, 100)}..."
            else movie.overview)
            Text(text = if (movie.isFavourite)
                "Remove from favourite"
            else "Add to favourite",
                modifier = Modifier.background(Color.Green).clickable {
                    toggleFavourite(movie)
                }
            )
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(movie = Movie(
        adult = false,
        backdropPath = "",
        genreIds = listOf(),
        id = 0,
        originalLanguage = "",
        originalTitle = "",
        overview = "Test overview",
        popularity = 0.0,
        posterPath = "",
        releaseDate = "",
        title = "Test video",
        video = false,
        voteAverage = 0.0,
        voteCount = 0
    ), onSelectMovie = {}, toggleFavourite = {})
}