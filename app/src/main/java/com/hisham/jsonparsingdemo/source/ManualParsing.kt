package com.hisham.jsonparsingdemo.source

import com.google.gson.Gson
import com.hisham.jsonparsingdemo.model.Movie
import com.hisham.jsonparsingdemo.model.MovieObject
import java.io.BufferedInputStream
import java.lang.Exception
import java.net.URL
import org.json.JSONObject

class ManualParsing : MoviesApi {
    override suspend fun getMovies(): MovieObject {
        try {
            val url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/json/moviesDemoItem.json")
            val connection = url.openConnection()
            connection.connect()

            val inputStream = BufferedInputStream(url.openStream())
            val bufferedReader = inputStream.bufferedReader()

            val stringBuffer = StringBuffer()

            for (line in bufferedReader.readLines()) {
                stringBuffer.append(line)
            }
            bufferedReader.close()

            // JSON parsing
            val json = stringBuffer.toString()

            return Gson().fromJson(json, MovieObject::class.java)

//            val topLevelObject = JSONObject(json)
//            val moviesArray = topLevelObject.getJSONArray("movies")
//            val movieObject = moviesArray.getJSONObject(0)
//            val movieName = movieObject.getString("movie")
//            val movieYear = movieObject.getInt("year")
//            return MovieObject(listOf(Movie(movieName.plus(" From manual parsing"), movieYear)))
        } catch (e: Exception) {
            return MovieObject(emptyList())
        }
    }

    override suspend fun getMovie(): Movie {
        try {
            val url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/json/movie.json")
            val connection = url.openConnection()
            connection.connect()

            val inputStream = BufferedInputStream(url.openStream())
            val bufferedReader = inputStream.bufferedReader()

            val stringBuffer = StringBuffer()

            for (line in bufferedReader.readLines()) {
                stringBuffer.append(line)
            }
            bufferedReader.close()

            // JSON parsing
            val json = stringBuffer.toString()

            return Gson().fromJson(json, Movie::class.java)

//            val topLevelObject = JSONObject(json)
//            val moviesArray = topLevelObject.getJSONArray("movies")
//            val movieObject = moviesArray.getJSONObject(0)
//            val movieName = movieObject.getString("movie")
//            val movieYear = movieObject.getInt("year")
//            return MovieObject(listOf(Movie(movieName.plus(" From manual parsing"), movieYear)))
        } catch (e: Exception) {
            return Movie("", -1, "")
        }
    }
}