package com.hisham.jsonparsingdemo.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hisham.jsonparsingdemo.model.Movie
import com.hisham.jsonparsingdemo.source.DataRepository
import com.hisham.jsonparsingdemo.source.ManualParsing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    // LiveData
    private val movieList = MutableLiveData<Movie>()

    private val dataRepository = DataRepository(ManualParsing())
//    private val dataRepository = DataRepository(RetrofitBuilder.getService())

    fun getMovies(): LiveData<Movie> {
        viewModelScope.launch {
            val movieData = withContext(Dispatchers.IO) {
                dataRepository.getMovie()
            }
            movieList.value = movieData
        }
        return movieList
    }

}