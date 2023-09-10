package com.vikravch.cellcomexam.movies_domain.use_case

data class MoviesUseCases(
    val getPopularFilms: GetPopularFilms,
    val markAsFavourite: ToggleFavourite,
    val getFavouriteFilms: GetFavouriteFilms,
    val getCurrentlyBroadcastFilms: GetCurrentlyBroadcastFilms
)