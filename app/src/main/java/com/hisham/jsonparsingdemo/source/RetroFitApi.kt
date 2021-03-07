package com.hisham.jsonparsingdemo.source

import com.hisham.jsonparsingdemo.model.Movie
import com.hisham.jsonparsingdemo.model.MovieObject
import retrofit2.http.GET

interface RetroFitApi : MoviesApi {

    @GET("/json/moviesData.json")
    override suspend fun getMovies(): MovieObject


    @GET("/json/movie.json")
    override suspend fun getMovie(): Movie
}