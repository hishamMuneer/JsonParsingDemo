package com.hisham.jsonparsingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hisham.jsonparsingdemo.databinding.ActivityMainBinding
import com.hisham.jsonparsingdemo.vm.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    // View Model
    private lateinit var viewModel: MainActivityViewModel

    // View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getMovies().observe(this) {
            binding.tvHello.text = it.movie.plus(" - ").plus(it.year)
            Glide.with(this).load(it.image).into(binding.imageView)
        }
    }
}