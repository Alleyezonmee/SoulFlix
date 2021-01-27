package com.soulinc.soulflix.base.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * paras's creation on 10-01-2021
 */
abstract class BaseFragment : Fragment() {

  @LayoutRes
  open fun layoutRes(): Int = -1

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return if (layoutRes() != -1) inflater.inflate(layoutRes(), container, false) else null
  }
}