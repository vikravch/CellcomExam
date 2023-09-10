package com.vikravch.cellcomexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        /*Surface(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Text(text = "Movies List Page")
                        }*/
                        MoviesListPage()
                    }
                    composable("details") {
                        MovieDetailPage()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CellcomExamTheme {
        Greeting("Android")
    }
}