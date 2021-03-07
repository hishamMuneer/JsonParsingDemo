package com.hisham.jsondemo.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hisham.jsondemo.model.Movie
import com.hisham.jsondemo.retrofit.RetrofitApi
import com.hisham.jsondemo.retrofit.RetrofitInstance
import com.hisham.jsondemo.source.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
//    private val dataRepository = DataRepository(ManualParsingImpl())
    private val dataRepository = DataRepository(RetrofitInstance.service)

    val movieLiveData = MutableLiveData<Movie>()

    fun fetchMovie() {
        viewModelScope.launch {
            val movie = withContext(Dispatchers.IO) {
                dataRepository.getMovies().movies[2]
            }
            movieLiveData.value = movie
        }
    }

}