package com.soulinc.soulflix

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * paras's creation on 20-01-2021
 */

inline fun <T : ViewBinding> ViewGroup.viewBinding(binder: (LayoutInflater, ViewGroup, Boolean) -> T): T = binder(LayoutInflater.from(context), this, true)