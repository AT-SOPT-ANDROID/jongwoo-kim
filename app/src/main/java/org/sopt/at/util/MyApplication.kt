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

        const val USER_ID = "userId"
        const val LOGIN_ID = "loginId"
        const val PASSWORD = "password"
    }

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceUtil(this)
    }
}