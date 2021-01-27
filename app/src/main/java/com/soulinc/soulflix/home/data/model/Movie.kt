package com.soulinc.soulflix.home.data.model

import com.google.gson.annotations.SerializedName

/**
 * paras's creation on 11-01-2021
 */
data class Movie(
  @SerializedName("adult") val isAdult: Boolean,
  @SerializedName("backdrop_path") val backdropPath: String,
  @SerializedName("genre_ids") val genreIds: List<Int>,
  @SerializedName("id") val id: Int,
  @SerializedName("original_language") val originalLanguage: String,
  @SerializedName("original_title") val originalTitle: String,
  @SerializedName("poster_path") val posterPath: String,
  @SerializedName("release_date") val releaseDate: String,
  @SerializedName("title") val title: String,
  @SerializedName("vote_average") val voteAverage: Double,
  @SerializedName("vote_count") val voteCount: Int
)