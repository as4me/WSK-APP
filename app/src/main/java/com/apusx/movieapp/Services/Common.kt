package com.apusx.movieapp.Services

object Common {
    private val BASE_URL = "https://imdb-api.com/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}