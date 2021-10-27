package com.apusx.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apusx.movieapp.R
import com.potyvideo.library.AndExoPlayerView


class MoviePlay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_play)


        val andExoPlayerView = findViewById<AndExoPlayerView>(R.id.andExoPlayerView)
        val andExoPlayerVieeeew = findViewById<AndExoPlayerView>(R.id.andExoPlayerView)
        andExoPlayerView.setSource("https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4")
    }
}