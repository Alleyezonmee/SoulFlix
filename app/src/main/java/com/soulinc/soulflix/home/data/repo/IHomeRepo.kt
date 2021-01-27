package com.soulinc.soulflix.home.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.soulinc.soulflix.home.data.model.ListResponse
import retrofit2.Response

/**
 * paras's creation on 11-01-2021
 */
interface IHomeRepo {

  suspend fun getMovies(liveData: MutableLiveData<Response<ListResponse>>, page: Int): LiveData<Response<ListResponse>>
}