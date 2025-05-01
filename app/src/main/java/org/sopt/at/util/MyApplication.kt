package org.sopt.at.util

import android.app.Application
import android.widget.Toast
import dagger.hilt.android.HiltAndroidApp
import org.sopt.at.util.preference.PreferenceUtil
import kotlin.system.exitProcess

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil

        // intent or bundle key
        const val ID_KEY = "ID"
        const val PW_KEY = "PW"

        // prefs key
        const val PREFS_ID_KEY = "ID"
        const val PREFS_PW_KEY = "PW"
    }

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceUtil(this)
    }
}