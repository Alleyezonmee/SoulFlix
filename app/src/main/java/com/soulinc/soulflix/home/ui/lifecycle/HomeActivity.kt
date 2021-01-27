package com.soulinc.soulflix.home.ui.lifecycle

import android.os.Bundle
import com.soulinc.soulflix.R
import com.soulinc.soulflix.base.lifecycle.BaseActivity

class HomeActivity : BaseActivity() {

    override fun getScreenName(): String = HomeActivity::class.java.name

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun fragmentContainerRes(): Int = R.id.fl_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragment<HomeFragment>(HomeFragment(), false)
    }
}