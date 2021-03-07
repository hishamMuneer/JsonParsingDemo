package com.hisham.jsondemo.model

data class Movies(
    val movies: List<Movie>
)

data class Movie(
    val cast: List<Cast>,
    val director: String,
    val duration: String,
    val image: String,
    val movie: String,
    val rating: Double,
    val story: String,
    val tagline: String,
    val year: Int
)

data class Cast(
    val name: String
)
