package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class Video(
    val extension: String,
    val mimeType: String,
    val quality: String,
    val url: String
)