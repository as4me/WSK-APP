package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class Actor(
    val asCharacter: String,
    val id: String,
    val image: String,
    val name: String
)