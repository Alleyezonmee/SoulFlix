package com.soulinc.soulflix.home.data.model

import com.google.gson.annotations.SerializedName

/**
 * paras's creation on 12-01-2021
 */
data class ListResponse(
  @SerializedName("page") val page: Int,
  @SerializedName("results") val result: List<Movie>
)