package com.apusx.movieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.apusx.movieapp.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_login: Button = findViewById(R.id.button_login)

        button_login.setOnClickListener {
            startActivity(Intent(this, MovieListActivity::class.java))
        }
    }


}