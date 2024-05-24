package com.geunoo.android_lab.common

import android.content.Context
import android.content.SharedPreferences

private const val SHARED_PREFERENCE = "shortBook"

class LoginPreferences(context: Context) {
    private val preference: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
    }

    private val editor: SharedPreferences.Editor by lazy {
        preference.edit()
    }

    fun isLogin() = !preference.getString("token", "").isNullOrBlank()

    fun setToken(token: String) {
        editor.putString("token", token).apply()
    }

    fun getToken(): String {
        return ("Bearer " + preference.getString("token", ""))
    }

    fun deleteToken() {
        editor.clear().apply()
    }
}