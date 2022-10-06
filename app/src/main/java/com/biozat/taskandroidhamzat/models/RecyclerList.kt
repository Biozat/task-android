package com.biozat.taskandroidhamzat.models

data class RecyclerList(val memes: ArrayList<RecyclerData>)
    data class RecyclerData(val id: Int, val name: String, val url: String)
