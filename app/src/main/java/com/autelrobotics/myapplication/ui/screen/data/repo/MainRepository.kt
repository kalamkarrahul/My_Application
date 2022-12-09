package com.autelrobotics.myapplication.ui.screen.data.repo

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.autelrobotics.myapplication.ui.screen.data.model.Movie
import com.autelrobotics.myapplication.ui.screen.data.model.NETWORK_PAGE_SIZE
import com.autelrobotics.myapplication.ui.screen.data.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies(): LiveData<PagingData<Movie>> {

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MoviePagingSource(retrofitService)
            }
        , initialKey = 1
        ).liveData
    }

}