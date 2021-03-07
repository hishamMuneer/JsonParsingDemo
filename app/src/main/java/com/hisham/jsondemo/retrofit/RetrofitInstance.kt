package com.hisham.jsondemo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder = Retrofit.Builder()
        .baseUrl("https://jsonparsingdemo-cec5b.firebaseapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = builder.create(RetrofitApi::class.java)

}