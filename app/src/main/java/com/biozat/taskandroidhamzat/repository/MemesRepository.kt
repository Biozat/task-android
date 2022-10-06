package com.biozat.taskandroidhamzat.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.biozat.taskandroidhamzat.models.Jokes
import com.biozat.taskandroidhamzat.network.RetrofitService

class MemesRepository(private val retrofitService: RetrofitService) {
    private val memesLiveData = MutableLiveData<Jokes>()

    val memes: LiveData<Jokes>
    get() = memesLiveData

    suspend fun getMemes(){
        val result = retrofitService.getDataFromApi()
        if(result.body() != null){
            memesLiveData.postValue(result.body())
        }
    }
}