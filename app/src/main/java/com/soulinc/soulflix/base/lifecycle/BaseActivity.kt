package com.soulinc.soulflix.base.lifecycle

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import timber.log.Timber

/**
 * paras's creation on 10-01-2021
 */
abstract class BaseActivity : AppCompatActivity() {

  abstract fun getScreenName(): String?

  abstract fun getLayoutId(): Int

  @IdRes
  open fun fragmentContainerRes(): Int = -1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (getLayoutId() > 0) setContentView(getLayoutId())
  }

  override fun onStart() {
    Timber.i("%s onStart ---- Task ID: $taskId", getScreenName())
    super.onStart()
  }

  fun <F> showFragment(fragment: Fragment, addToBackStack: Boolean) where F : Fragment {
    if (fragmentContainerRes() == -1) throw IllegalStateException("Please override fragmentContainerRes() and give a valid layout ID.")
    fragmentContainerRes().let { containerRes ->
      supportFragmentManager.beginTransaction().replace(containerRes, fragment, fragment.tag).let {
        if (addToBackStack) it.addToBackStack(fragment.tag)
        try {
          it.commit()
        } catch (e: Exception) {
          it.commitAllowingStateLoss()
        } catch (e: Exception) {
          Timber.e(e)
        }
      }
    }
  }
}