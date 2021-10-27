package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class Result(
    val description: String,
    val id: String,
    val image: String,
    val resultType: String,
    val title: String
)