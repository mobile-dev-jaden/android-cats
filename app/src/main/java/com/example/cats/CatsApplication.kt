package com.example.cats

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.hicare.practice.sample.data.StethoSettings

@HiltAndroidApp
class CatsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Stetho Settings
        StethoSettings.initialize(this)
    }
}