package com.example.cats.activities

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.NavHostFragment
import com.example.cats.R
import com.example.cats.base.BaseActivity
import com.example.cats.databinding.ActivityMainBinding
import com.example.cats.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainActivityBackPressedCallback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            /* Handle On BackPressed */
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_content_main)
            .let { it as NavHostFragment }

        Navigator.get().initialize(navHostFragment.navController)

        setBottomNavigationBarCallback()
    }


    private fun setBottomNavigationBarCallback() {
       binding.bottomNavigator.setOnItemSelectedListener { item ->
           when (item.itemId) {
               R.id.page_1 -> {
                   Navigator.get().navToHomeFragment()
                   Navigator.get().isAtFragment(R.id.HomeFragment)
               }

               R.id.page_2 -> {
                   Navigator.get().navToSecondFragment()
                   Navigator.get().isAtFragment(R.id.SecondFragment)
               }

               else -> { false }
           }
       }
    }

    override fun onDestroy() {

        mainActivityBackPressedCallback.remove()

        super.onDestroy()
    }

}