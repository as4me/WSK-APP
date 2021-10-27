package com.apusx.movieapp.Services

import com.apusx.movieapp.Models.FilmsModel
import com.apusx.movieapp.Models.MovieItem
import com.apusx.movieapp.Models.YouTubeModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices {


    @GET("en/API/Top250Movies/k_6uyj5b9n")
    fun get250topmovies(): Call<FilmsModel>

    @GET("en/API/MostPopularMovies/k_6uyj5b9n")
    fun getmostpopularmovies(): Call<FilmsModel>

    @GET("/en/API/Title/k_6uyj5b9n/{id}")
    fun getonefilm(@Path("id") id : String): Call<MovieItem>


    @GET("/en/API/YouTube/k_6uyj5b9n/8hP9D6kZseM")
    fun getYouTube(@Path("id") id : String): Call<YouTubeModel>


}