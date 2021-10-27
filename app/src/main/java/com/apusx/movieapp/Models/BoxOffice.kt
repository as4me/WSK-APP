package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class BoxOffice(
    val budget: String,
    val cumulativeWorldwideGross: String,
    val grossUSA: String,
    val openingWeekendUSA: String
)