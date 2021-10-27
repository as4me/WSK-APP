package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class FilmsModel(
    val errorMessage: String,
    val items: List<Item>
)