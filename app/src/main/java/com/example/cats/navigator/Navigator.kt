package com.example.cats.navigator

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

    fun navToFirstFragment() {
        navController.navigate(R.id.action_global_FirstFragment)
    }

    fun navToSecondFragment() {
        navController.navigate(R.id.action_global_SecondFragment)
    }
}
