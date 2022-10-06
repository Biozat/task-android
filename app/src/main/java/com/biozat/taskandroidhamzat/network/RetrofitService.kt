package com.biozat.taskandroidhamzat.network

import com.biozat.taskandroidhamzat.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("g" )query: String): RecyclerList
}