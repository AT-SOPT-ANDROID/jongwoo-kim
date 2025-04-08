package org.sopt.at.util

import android.app.Application
import android.widget.Toast
import org.sopt.at.util.preference.PreferenceUtil
import kotlin.system.exitProcess

class MyApplication : Application() {

    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()

        prefs = PreferenceUtil(this)
    }

}