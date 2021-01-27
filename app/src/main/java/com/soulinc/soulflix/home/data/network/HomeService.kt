package com.soulinc.soulflix.home.data.network

import com.soulinc.soulflix.API_KEY
import com.soulinc.soulflix.home.data.model.ListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * paras's creation on 11-01-2021
 */
interface HomeService {

  @GET("movie/top_rated")
  suspend fun getMovies(@Query("page") page: Int, @Query("api_key") apiKey: String = API_KEY) : Response<ListResponse>
}