package com.soulinc.soulflix.base.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * paras's creation on 11-01-2021
 */
class RetrofitClient {

  companion object {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    fun getInstance() : Retrofit {
      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
  }
}