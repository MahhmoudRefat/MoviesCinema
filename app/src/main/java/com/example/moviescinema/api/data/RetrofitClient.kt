package com.example.moviescinema.api.data

import com.example.moviescinema.api.models.albumItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitClient {

    @GET("photo") // endpoint
    suspend fun getAllMovies(): Response<albumItem>

    companion object {
        const val base_URL = "https://jsonplaceholder.typicode.com/"
        var instance: RetrofitClient? = null
        fun getInstance():RetrofitClient{ // return the interface client
            if (instance == null) {
                val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                instance= retrofit.create(RetrofitClient::class.java)

            }
            return instance!!
        }
    }
}