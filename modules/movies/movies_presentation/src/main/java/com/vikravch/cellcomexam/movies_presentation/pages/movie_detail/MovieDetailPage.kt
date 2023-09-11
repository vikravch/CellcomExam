package com.vikravch.cellcomexam.movies_presentation.pages.movie_detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.vikravch.cellcomexam.core_ui.theme.CellcomExamTheme

@Composable
fun MovieDetailPage(
    id: Int,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.onEvent(MovieDetailsEvent.LoadMovieDetails(id))
    }

    CellcomExamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Log.d("MovieDetailsViewModel", "onEvent: ${viewModel.state.movie}")

            if(viewModel.state.error != null){
                Text(text = viewModel.state.error?.message?: "Unknown error")
            }
            if(viewModel.state.movie != null){
                val movie = viewModel.state.movie!!
                val painter =
                    rememberImagePainter(data = "https://image.tmdb.org/t/p/w500${movie.backdropPath}")

                Row(modifier = Modifier.fillMaxWidth()) {
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
                        Text(text = movie.overview)
                        Text(text = if (movie.isFavourite)
                            "Remove from favourite"
                        else "Add to favourite",
                            modifier = Modifier.background(Color.Green).clickable {
                                viewModel.onEvent(MovieDetailsEvent.ToggleFavourite(movie))
                            }
                        )
                    }
                }
            }
        }
    }
}