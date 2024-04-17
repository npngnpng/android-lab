package com.geunoo.android_lab.common

import android.content.Context
import android.content.SharedPreferences

private const val SHARED_PREFERENCE = "shortBook"

class LoginPreferences(context: Context) {
    private val preference: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
    }

    fun isLogin() = !preference.getString("token", "").isNullOrBlank()

    fun setToken(token: String) {
        preference.edit().putString("token", token).apply()
    }
}