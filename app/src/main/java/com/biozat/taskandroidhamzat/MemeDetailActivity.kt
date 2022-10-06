package com.biozat.taskandroidhamzat

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.biozat.taskandroidhamzat.databinding.ActivityMemeDetailBinding
import com.squareup.picasso.Picasso

class MemeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemeDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMemeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)




       val name = intent.extras?.getString("name")
        val url = intent.extras?.getString("url")
        setTitle(name)
        Picasso.get()
            .load(url)
            .into(binding.image)
        binding.textView.text = name

    }


}