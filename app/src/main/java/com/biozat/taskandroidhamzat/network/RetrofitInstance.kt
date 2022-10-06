package com.biozat.taskandroidhamzat.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        val BaseUrl = "https://api.imgflip.com"

        fun getRetrofitInstance(): Retrofit {

           return  Retrofit.Builder()
               .baseUrl(BaseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
         }
    }
}