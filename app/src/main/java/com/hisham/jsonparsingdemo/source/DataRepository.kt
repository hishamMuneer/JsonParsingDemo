package com.hisham.jsonparsingdemo.source

import com.hisham.jsonparsingdemo.model.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DataRepository(private val moviesApi: MoviesApi) {

    suspend fun getMovies(): List<Movie> {
        return moviesApi.getMovies().movies
    }

    suspend fun getMovie(): Movie {
        return moviesApi.getMovie()
    }
}