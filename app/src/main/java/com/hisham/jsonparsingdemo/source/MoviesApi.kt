package com.hisham.jsonparsingdemo.source

import com.hisham.jsonparsingdemo.model.Movie
import com.hisham.jsonparsingdemo.model.MovieObject

interface MoviesApi {
    suspend fun getMovies(): MovieObject

    suspend fun getMovie(): Movie
}