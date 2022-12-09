package com.autelrobotics.myapplication.ui.screen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.autelrobotics.myapplication.ui.screen.data.model.Movie
import com.autelrobotics.myapplication.ui.screen.data.repo.MainRepository

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()

    fun getMovieList(): LiveData<PagingData<Movie>> {
        return mainRepository.getAllMovies().cachedIn(viewModelScope)
    }

}