package com.biozat.taskandroidhamzat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.biozat.taskandroidhamzat.R
import com.biozat.taskandroidhamzat.RecyclerListFragment
import com.biozat.taskandroidhamzat.databinding.RecylerListRowBinding
import com.biozat.taskandroidhamzat.models.Jokes
import com.biozat.taskandroidhamzat.models.Meme

import com.squareup.picasso.Picasso

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var items = ArrayList<Meme>()

    fun setUpdatedData(items : ArrayList<Meme>){
        this.items = items
        notifyDataSetChanged()
    }
inner class ViewHolder(val binding: RecylerListRowBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = RecylerListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item  = items.get(position)
        val url = item.url
        Picasso.get()
            .load(url)
            .into(holder.binding.img)

        holder.binding.img.setOnClickListener{

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}