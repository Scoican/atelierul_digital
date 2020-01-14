package com.example.gamecollector.data.room

import com.example.gamecollector.core.Api
import com.example.gamecollector.data.Game
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

object GameApi {
    interface Service{
        @GET("/api/note/")
        suspend fun find(): List<Game>


        @GET("/api/note/{id}")
        suspend fun read(@Path("id") itemId: String): Game

    }

    val service: Service = Api.retrofit.create(Service::class.java)
}