package com.hisham.jsondemo.api

import com.hisham.jsondemo.model.Movies

interface MoviesApi {

    suspend fun getMovies() : Movies

}