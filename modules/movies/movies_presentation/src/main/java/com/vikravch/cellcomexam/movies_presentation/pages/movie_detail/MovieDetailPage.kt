package com.vikravch.cellcomexam.movies_presentation.pages.movie_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vikravch.cellcomexam.core_ui.theme.CellcomExamTheme

@Composable
fun MovieDetailPage() {
    CellcomExamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "Movie Detail Page")
        }
    }
}