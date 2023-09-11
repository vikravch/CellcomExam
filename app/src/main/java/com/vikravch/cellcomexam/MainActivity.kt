package com.vikravch.cellcomexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vikravch.cellcomexam.core_ui.theme.CellcomExamTheme
import com.vikravch.cellcomexam.movies_presentation.pages.movie_detail.MovieDetailPage
import com.vikravch.cellcomexam.movies_presentation.pages.movie_list.MoviesListPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CellcomExamTheme {
                NavHost(navController = navController, startDestination = Route.MOVIES) {
                    composable(Route.MOVIES) {
                        MoviesListPage(
                            onSelectMovie = {
                                navController.navigate(Route.MOVIE_DETAILS_DOMAIN+"/"+it)
                            }
                        )
                    }
                    composable(Route.MOVIE_DETAILS, arguments = listOf(navArgument("id") {
                        type = NavType.StringType
                    })) { backStackEntry ->
                        MovieDetailPage(
                            id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                        )
                    }
                }
            }
        }
    }
}