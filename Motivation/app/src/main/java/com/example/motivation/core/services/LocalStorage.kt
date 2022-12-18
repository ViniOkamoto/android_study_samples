package com.example.motivation.core.services

import android.content.Context
import android.content.SharedPreferences

class LocalStorage ( context: Context) {

    private val storage: SharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        storage.edit().putString(key,value).apply()
    }

    fun getString(key:String ): String {
        return storage.getString(key, "") ?: ""
    }
}