package com.apusx.movieapp.ui

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.apusx.movieapp.Adapters.CustomAdapter
import com.apusx.movieapp.Models.FilmsModel
import com.apusx.movieapp.Models.MovieItem
import com.apusx.movieapp.Models.YouTubeModel
import com.apusx.movieapp.R
import com.apusx.movieapp.Services.Common
import com.apusx.movieapp.Services.RetrofitServices
import com.bumptech.glide.Glide
import dmax.dialog.SpotsDialog
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieView : AppCompatActivity() {


    lateinit var mService: RetrofitServices
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_view)








        val Image: ImageView = findViewById(R.id.imageView_placeholder)

        val title_textView: TextView = findViewById(R.id.textView6)
        val year_textView: TextView = findViewById(R.id.textView7)
        val descpription: TextView = findViewById(R.id.textView8)
        val button: Button = findViewById(R.id.button)

        val id = intent.getStringExtra("id")

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        dialog.show()
        mService = Common.retrofitService

        id?.let { mService.getonefilm(it).enqueue(object : Callback<MovieItem> {

            override fun onResponse(
                call: Call<MovieItem>,
                response: Response<MovieItem>
            ) {

                Log.d("Retrofit",response.code().toString())

                if( response.isSuccessful){
                    dialog.dismiss()
                    Glide.with(applicationContext)
                        .load(response.body()?.image)
                        .centerCrop()
                        .into(Image)

                    title_textView.text = response.body()?.title
                    year_textView.text = response.body()?.year
                    descpription.text = response.body()?.plot




                }
            }

            override fun onFailure(call: Call<MovieItem>, t: Throwable) {
                Log.d("RETROFIT",t.localizedMessage)

            }
        }) }
        Log.d("TESt",id.toString())


        button.setOnClickListener {
            getYouTube()
        }

    }


    fun getYouTube(){
        mService.getYouTube("8hP9D6kZseM").enqueue(object : Callback<YouTubeModel> {

            override fun onResponse(
                call: Call<YouTubeModel>,
                response: Response<YouTubeModel>
            ) {

                Log.d("Retrofit",response.code().toString())

               if (response.isSuccessful){
                   Log.d("Retrofit",   response.body()?.videos?.get(0)?.url.toString())

               }
            }

            override fun onFailure(call: Call<YouTubeModel>, t: Throwable) {
                Log.d("RETROFIT",t.localizedMessage)

            }
        })
    }
}