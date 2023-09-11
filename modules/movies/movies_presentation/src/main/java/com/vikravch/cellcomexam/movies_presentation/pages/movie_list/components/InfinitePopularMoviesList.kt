package com.vikravch.cellcomexam.movies_presentation.pages.movie_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.vikravch.cellcomexam.core_ui.components.InfiniteListHandler
import com.vikravch.cellcomexam.movies_domain.model.Movie

@Composable
fun InfiniteMoviesList(
    listItems: List<Movie>,
    onLoadMore: () -> Unit,
    onSelectMovie: (Int) -> Unit,
    toggleFavourite: (Movie) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState
    ) {
        listItems.forEach { movie ->
            item{
                MovieItem(movie = movie,
                    onSelectMovie = onSelectMovie,
                    toggleFavourite = toggleFavourite)
            }
        }
    }

    InfiniteListHandler(listState = listState) {
        onLoadMore()
    }
}