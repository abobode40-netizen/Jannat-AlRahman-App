package com.jannat.alrahman.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jannat.alrahman.data.BackupData

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences("jannat_alrahman_data", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveBackup(backup: BackupData) {
        val json = gson.toJson(backup)
        sharedPreferences.edit().putString("backup_data", json).apply()
    }

    fun getBackup(): BackupData? {
        val json = sharedPreferences.getString("backup_data", null)
        return if (json != null) gson.fromJson(json, BackupData::class.java) else null
    }

    fun saveLastPage(page: Int) {
        sharedPreferences.edit().putInt("last_page", page).apply()
    }

    fun getLastPage(): Int {
        return sharedPreferences.getInt("last_page", 0)
    }

    fun saveDarkMode(isDark: Boolean) {
        sharedPreferences.edit().putBoolean("dark_mode", isDark).apply()
    }

    fun isDarkMode(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    }
}
