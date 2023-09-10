package com.vikravch.cellcomexam.movies_presentation.pages.movie_list

import android.util.Log
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
import com.vikravch.cellcomexam.core_ui.components.FilterSwitcher

@Composable
fun MoviesListPage(
    viewModel: MoviesListViewModel = hiltViewModel()
) {
    val (filter, setFilter) = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true){
        viewModel.onEvent(MoviesListEvent.LoadPopularMovies)
    }
    Log.d("MoviesListViewModel", "MoviesListPage: ${viewModel.state.movies}")
    CellcomExamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column{
                FilterSwitcher(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    text = "Filter by:",
                    onSwitch = {
                        setFilter(it)
                        when(it){
                            0 -> viewModel.onEvent(MoviesListEvent.LoadPopularMovies)
                            1 -> viewModel.onEvent(MoviesListEvent.LoadCurrentlyBroadcastMovies)
                            2 -> viewModel.onEvent(MoviesListEvent.LoadFavouriteMovies)
                        }
                    },
                    selected = filter
                )
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                ){
                    /*items(viewModel.state.movies.size) { index ->
                        Text(text = viewModel.state.movies[index].backdropPath)
                    }*/
                    viewModel.state.movies.forEach { movie ->
                        item{
                            Text(text = movie.title)
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
    MoviesListPage()
}