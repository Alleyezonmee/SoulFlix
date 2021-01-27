package com.soulinc.soulflix.home.ui.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soulinc.soulflix.R
import com.soulinc.soulflix.base.lifecycle.BaseFragment
import com.soulinc.soulflix.databinding.FragmentHomeBinding
import com.soulinc.soulflix.hideView
import com.soulinc.soulflix.home.controller.TopRatedMoviesController
import com.soulinc.soulflix.home.data.model.Movie
import com.soulinc.soulflix.home.viewmodel.HomeViewModel
import com.soulinc.soulflix.onScrolledToBottom
import com.soulinc.soulflix.showView

/**
 * paras's creation on 12-01-2021
 */
class HomeFragment : BaseFragment(), TopRatedMoviesController.Listener {

  override fun layoutRes(): Int = R.layout.fragment_home

  private lateinit var viewModel: HomeViewModel
  private lateinit var binding: FragmentHomeBinding
  private val controller by lazy { TopRatedMoviesController(this) }
  private var page = 1
  private var loading: Boolean = false
  private var movieList: MutableList<Movie> = mutableListOf()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    initViewModel()
    setObservers()
    initRecyclerView()
    initListeners()
    getMovies()
  }

  private fun initRecyclerView() {
    binding.ervMovies.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    binding.ervMovies.setController(controller)
  }

  private fun initListeners() {
    binding.ervMovies.onScrolledToBottom { getMovies() }
  }

  private fun getMovies() {
    if (loading) return
    loading = true
    binding.pbPagination.showView()
    viewModel.getMovies(page)
  }

  private fun setObservers() {
    viewModel.topRatedMoviesData.observe(this, Observer { response ->
      binding.pbPagination.hideView()
      loading = false
      response.body()?.let {
        movieList.addAll(it.result)
        page++
        controller.setData(movieList)
      }
    })
  }

  private fun initViewModel() {
    viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
  }

  override fun onMovieClick(movie: Movie) {
    TODO("Not yet implemented")
  }

  override fun onFavoriteClick(movie: Movie) {
    TODO("Not yet implemented")
  }

  override fun onWatchedClick(movie: Movie) {
    TODO("Not yet implemented")
  }

  override fun onShareClick(movieId: String) {
    TODO("Not yet implemented")
  }
}