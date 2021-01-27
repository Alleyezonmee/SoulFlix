package com.soulinc.soulflix.home.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.soulinc.soulflix.home.data.model.Movie
import com.soulinc.soulflix.home.ui.view.topRatedMovieItem

/**
 * paras's creation on 18-01-2021
 */
class TopRatedMoviesController(private val listener: Listener?): TypedEpoxyController<List<Movie>>() {
  override fun buildModels(data: List<Movie>?) {
    data?.forEach {
      topRatedMovieItem {
        id(it.toString())
        withMovie(it)
        onItemClick { listener?.onMovieClick(it) }
        onFavoriteClick { listener?.onFavoriteClick(it) }
        onWatchedClick { listener?.onWatchedClick(it) }
        onShareClick { listener?.onShareClick(it) }
      }
    }
  }

  interface Listener {
    fun onMovieClick(movie: Movie)
    fun onFavoriteClick(movie: Movie)
    fun onWatchedClick(movie: Movie)
    fun onShareClick(movieId: String)
  }
}