package com.hisham.jsonparsingdemo.source

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonparsingdemo-cec5b.web.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService(): RetroFitApi {
        return retrofit.create(RetroFitApi::class.java)
    }

}