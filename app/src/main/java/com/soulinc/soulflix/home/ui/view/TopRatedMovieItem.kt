package com.soulinc.soulflix.home.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import coil.load
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelProp.Option.DoNotHash
import com.airbnb.epoxy.ModelView
import com.soulinc.soulflix.createUrlForImage
import com.soulinc.soulflix.databinding.ItemTopRatedMovieBinding
import com.soulinc.soulflix.home.data.model.Movie
import com.soulinc.soulflix.viewBinding

/**
 * paras's creation on 18-01-2021
 */
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TopRatedMovieItem @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : CardView(context, attrs, defStyle) {

  private val binding = viewBinding(ItemTopRatedMovieBinding::inflate)

  init {
    radius = 32F
  }

  private var onItemClick: (Movie) -> Unit = { _ -> }
  private var onFavoriteClick: (Movie) -> Unit = { _ -> }
  private var onShareClick: (String) -> Unit = { _ -> }
  private var onWatchedClick: (Movie) -> Unit = { _ -> }

  @ModelProp
  fun withMovie(movie: Movie) {
    binding.ivThumbnail.load(createUrlForImage(movie.posterPath))
    binding.tvTitle.text = movie.title
    binding.tvReleasedDate.text = movie.releaseDate
    binding.tvGenres.text = movie.genreIds[0].toString()
    binding.rbMovieRating.rating = (movie.voteAverage / 2).toFloat()
  }

  @ModelProp(DoNotHash)
  fun onItemClick(action: (Movie) -> Unit) {
    onItemClick = action
  }

  @ModelProp(DoNotHash)
  fun onFavoriteClick(action: (Movie) -> Unit) {
    onFavoriteClick = action
  }

  @ModelProp(DoNotHash)
  fun onShareClick(action: (String) -> Unit) {
    onShareClick = action
  }

  @ModelProp(DoNotHash)
  fun onWatchedClick(action: (Movie) -> Unit) {
    onWatchedClick = action
  }
}