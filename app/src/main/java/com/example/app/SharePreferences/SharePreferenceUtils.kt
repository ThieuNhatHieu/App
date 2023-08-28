package com.example.app.SharePreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE

object SharePreferenceUtils {

    fun saveName(name: String, context: Context) {
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        preferences.edit().putString("name", name).apply()
    }

    fun getName(context: Context): String {
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        return preferences.getString("name", "") ?:""
    }
}