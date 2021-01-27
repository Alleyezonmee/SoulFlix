package com.soulinc.soulflix.home.data.repo

import androidx.lifecycle.MutableLiveData
import com.soulinc.soulflix.base.BaseRepository
import com.soulinc.soulflix.base.network.RetrofitClient
import com.soulinc.soulflix.home.data.model.ListResponse
import com.soulinc.soulflix.home.data.network.HomeService
import retrofit2.Response

/**
 * paras's creation on 11-01-2021
 */
class HomeRepoImpl : IHomeRepo, BaseRepository() {

  private val service = RetrofitClient.getInstance().create(HomeService::class.java)

  override suspend fun getMovies(liveData: MutableLiveData<Response<ListResponse>>, page: Int) = callApi(liveData) { service.getMovies(page) }
}