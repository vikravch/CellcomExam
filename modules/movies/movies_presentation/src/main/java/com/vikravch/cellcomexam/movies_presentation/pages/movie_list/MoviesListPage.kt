package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vikravch.cellcomexam.core_ui.theme.CellcomExamTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.vikravch.cellcomexam.core_ui.components.FilterMode
import com.vikravch.cellcomexam.core_ui.components.FilterSwitcher
import com.vikravch.cellcomexam.movies_presentation.pages.movie_list.components.InfiniteMoviesList
import com.vikravch.cellcomexam.movies_presentation.pages.movie_list.components.MovieItem

@Composable
fun MoviesListPage(
    onSelectMovie: (Int) -> Unit,
    viewModel: MoviesListViewModel = hiltViewModel()
) {
    val (filter, setFilter) = remember { mutableStateOf<FilterMode>(FilterMode.Popular) }

    LaunchedEffect(key1 = true){
        viewModel.onEvent(MoviesListEvent.LoadPopularMovies)
        viewModel.onEvent(MoviesListEvent.LoadCurrentlyBroadcastMovies)
        viewModel.onEvent(MoviesListEvent.LoadFavouriteMovies)
    }
    CellcomExamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column{

                if(viewModel.state.error != null){
                    Text(text = viewModel.state.error?.message?: "Unknown error")
                }

                FilterSwitcher(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    onSwitch = {
                        setFilter(it)
                        when(it){
                            FilterMode.BroadcastNow -> viewModel.onEvent(MoviesListEvent.LoadPopularMovies)
                            FilterMode.Favourite -> viewModel.onEvent(MoviesListEvent.LoadCurrentlyBroadcastMovies)
                            FilterMode.Popular -> viewModel.onEvent(MoviesListEvent.LoadFavouriteMovies)
                        }
                    },
                    selected = filter
                )
                when(filter){
                    FilterMode.Popular -> {
                        InfiniteMoviesList(listItems = viewModel.state.popularFilms,
                            toggleFavourite = {
                                viewModel.onEvent(MoviesListEvent.ToggleFavouriteMovie(it, filter))
                            },
                            onLoadMore = {
                                viewModel.onEvent(MoviesListEvent.LoadMorePopularMovies)
                            },
                            onSelectMovie = onSelectMovie
                        )
                    }
                    FilterMode.BroadcastNow -> {
                        InfiniteMoviesList(listItems = viewModel.state.broadcastFilms,
                            toggleFavourite = {
                                viewModel.onEvent(MoviesListEvent.ToggleFavouriteMovie(it, filter))
                            },
                            onLoadMore = {
                                viewModel.onEvent(MoviesListEvent.LoadMoreCurrentlyBroadcastMovies)
                            },
                            onSelectMovie = onSelectMovie
                        )
                    }
                    FilterMode.Favourite -> {
                        LazyColumn {
                            val movies = viewModel.state.favouriteMovies
                            movies.forEach { movie ->
                                item{
                                    MovieItem(movie = movie,
                                        onSelectMovie = onSelectMovie,
                                        toggleFavourite = {
                                            viewModel.onEvent(MoviesListEvent.ToggleFavouriteMovie(movie, filter))
                                        })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MoviesListPagePreview() {
    MoviesListPage(
        onSelectMovie = {}
    )
}