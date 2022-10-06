package com.biozat.taskandroidhamzat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biozat.taskandroidhamzat.models.RecyclerList

class MainActivtyViewmodel: ViewModel( ) {
     lateinit var recyclerListLiveData: MutableLiveData<RecyclerList>

     init {
         recyclerListLiveData = MutableLiveData()
     }



}