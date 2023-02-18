package com.example.cats.navigator

import androidx.annotation.IdRes
import androidx.navigation.NavController
import com.example.cats.R

class Navigator private constructor() {
    companion object {
        @Volatile
        private var instance: Navigator? = null

        fun get() = instance ?: synchronized(this) {
            instance ?: Navigator().also { instance = it }
        }
    }

    private lateinit var navController: NavController

    fun initialize(navController: NavController) {
        this.navController = navController
    }

    fun navToHomeFragment() {
        navController.navigate(R.id.action_global_HomeFragment)
    }

    fun navToFirstFragment() {
        navController.navigate(R.id.action_global_FirstFragment)
    }

    fun navToSecondFragment() {
        navController.navigate(R.id.action_global_SecondFragment)
    }

    fun isAtFragment(@IdRes fragmentId: Int) =
        getCurrentFragmentId() == fragmentId

    private fun getCurrentFragmentId(): Int? =
        navController.currentDestination?.id
}
