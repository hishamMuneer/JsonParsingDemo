package com.hisham.jsondemo.source

import com.google.gson.Gson
import com.hisham.jsondemo.api.MoviesApi
import com.hisham.jsondemo.model.Movies
import java.io.BufferedInputStream
import java.net.URL

class ManualParsingImpl : MoviesApi {
    override suspend fun getMovies(): Movies {

        val url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/json/moviesDemoItem.json")
        val connection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line in bufferedReader.readLines()) {
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val fullJson = stringBuffer.toString()

        return Gson().fromJson(fullJson, Movies::class.java)

//        // json parsing
//        val jsonObjectMovies = JSONObject(fullJson)
//        val jsonArray = jsonObjectMovies.getJSONArray("movies")
//        val jsonObjectMovie = jsonArray.getJSONObject(0)
//
//        val movieName = jsonObjectMovie.getString("movie")
//        val year = jsonObjectMovie.getInt("year")
//        val image = jsonObjectMovie.getString("image")
//        return Movies(listOf(Movie(movieName, year, image)))

    }
}