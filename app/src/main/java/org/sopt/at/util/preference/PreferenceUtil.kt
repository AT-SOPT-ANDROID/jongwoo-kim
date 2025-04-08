package org.sopt.at.util.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getData(key: String): String? = prefs.getString(key, "")

    fun setData(key: String, value: String) = prefs.edit().putString(key, value).commit()
}