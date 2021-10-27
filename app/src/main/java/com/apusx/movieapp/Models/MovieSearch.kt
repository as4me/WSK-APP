package com.apusx.movieapp.Models


data class MovieSearch(
    val errorMessage: String,
    val expression: String,
    val results: List<Result>,
    val searchType: String
)