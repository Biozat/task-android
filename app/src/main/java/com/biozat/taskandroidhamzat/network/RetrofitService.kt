package com.biozat.taskandroidhamzat.network

import com.biozat.taskandroidhamzat.models.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/get_memes")
    suspend fun getDataFromApi(): Response<Jokes>
}