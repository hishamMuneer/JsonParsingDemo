package com.hisham.jsondemo.retrofit

import com.hisham.jsondemo.api.MoviesApi
import com.hisham.jsondemo.model.Movies
import retrofit2.http.GET

interface RetrofitApi : MoviesApi {

    @GET("/json/moviesData.json")
    override suspend fun getMovies(): Movies

}