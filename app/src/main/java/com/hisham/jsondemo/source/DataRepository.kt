package com.hisham.jsondemo.source

import com.hisham.jsondemo.api.MoviesApi
import com.hisham.jsondemo.model.Movies

class DataRepository(private val moviesApi: MoviesApi) {

    suspend fun getMovies() : Movies{
        return moviesApi.getMovies()
    }

}