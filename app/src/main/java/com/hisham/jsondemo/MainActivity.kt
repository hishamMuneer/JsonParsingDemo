package com.hisham.jsondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hisham.jsondemo.databinding.ActivityMainBinding
import com.hisham.jsondemo.vm.MainViewModel

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // View Model
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.movieLiveData.observe(this) {
            binding.tvHello.text = it.toString()
            Glide.with(this).load(it.image).into(binding.imageView)
        }
        viewModel.fetchMovie()


    }
}