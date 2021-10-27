package com.apusx.movieapp.Models


import com.google.gson.annotations.SerializedName

data class YouTubeModel(
    val description: String,
    val duration: String,
    val errorMessage: String,
    val image: String,
    val title: String,
    val uploadDate: String,
    val videoId: String,
    val videos: List<Video>
)