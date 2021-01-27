package com.soulinc.soulflix

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * paras's creation on 20-01-2021
 */

fun createUrlForImage(posterPath: String): String = BASE_URL_FOR_IMAGES + "w500" + posterPath

fun RecyclerView.onScrolledToBottom(action: () -> Unit) {
  addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
      if (dy > 0) {
        (layoutManager as LinearLayoutManager).let { manager ->
          val visibleItem = manager.childCount
          val totalItem = manager.itemCount
          val scrolledItems = manager.findFirstVisibleItemPosition()
          if (visibleItem + scrolledItems >= totalItem - 5 / 2) {
            action()
          }
        }
      }
    }
  })
}

fun View.showView() {
  visibility = View.VISIBLE
}

fun View.hideView() {
  visibility = View.GONE
}

fun View.invisibleView() {
  visibility = View.INVISIBLE
}