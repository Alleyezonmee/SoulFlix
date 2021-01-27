package com.soulinc.soulflix.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soulinc.soulflix.home.data.model.ListResponse
import com.soulinc.soulflix.home.data.repo.HomeRepoImpl
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * paras's creation on 11-01-2021
 */
class HomeViewModel : ViewModel() {

  private val repo = HomeRepoImpl()

  val topRatedMoviesData = MutableLiveData<Response<ListResponse>>()

  fun getMovies(page: Int) = viewModelScope.launch { repo.getMovies(topRatedMoviesData, page) }

}