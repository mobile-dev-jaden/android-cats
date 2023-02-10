package net.hicare.practice.sample.data

import android.app.Application
import com.facebook.stetho.Stetho

object StethoSettings {
    fun initialize(application: Application) =
        Stetho.initializeWithDefaults(application)
}
