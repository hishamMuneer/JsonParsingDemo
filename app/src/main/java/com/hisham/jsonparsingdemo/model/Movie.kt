package com.hisham.jsonparsingdemo.model

data class Movie(val movie: String, val year: Int, val image: String)

data class MovieObject(val movies: List<Movie>)