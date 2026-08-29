package com.jannat.alrahman.utils

import android.content.Context
import androidx.datastore.dataStore
import com.google.gson.Gson
import com.jannat.alrahman.data.BackupData
import com.jannat.alrahman.data.dataStore
import androidx.datastore.preferences.core.edit
import com.jannat.alrahman.data.PreferencesKeys
import java.text.SimpleDateFormat
import java.util.*

class BackupManager(private val context: Context) {
    
    suspend fun exportBackup(): String {
        val lastReadPage = context.dataStore.data.collect { preferences ->
            preferences[PreferencesKeys.LAST_READ_PAGE] ?: 0
        }
        
        val darkMode = context.dataStore.data.collect { preferences ->
            preferences[PreferencesKeys.DARK_MODE] ?: false
        }
        
        // إنشاء كائن النسخة الاحتياطية
        val backup = BackupData(
            exportedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(Date()),
            settings = com.jannat.alrahman.data.Settings(
                isDarkMode = darkMode,
                selectedReciter = "abkar",
                quranFontSize = 24,
                enableAutoScroll = true,
                dailyMorningReminder = true,
                dailyEveningReminder = true
            ),
            bookmarks = emptyList(),
            lastReadPage = lastReadPage,
            todayTracker = com.jannat.alrahman.data.TodayTracker(
                date = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date()),
                prayers = mapOf(
                    "fajr" to "pending",
                    "dhuhr" to "pending",
                    "asr" to "pending",
                    "maghrib" to "pending",
                    "isha" to "pending"
                ),
                quranPagesRead = 0,
                quranTargetPages = 4,
                athkarCompletedCount = 0,
                athkarTargetCount = 12,
                treeGrowthPercentage = 0
            ),
            sebhaCount = 0,
            favoriteScholars = listOf(
                "الشيخ محمد بن صالح العثيمين",
                "الشيخ عبد الرزاق البدر",
                "الشيخ صالح المغامسي"
            )
        )
        
        return Gson().toJson(backup)
    }
    
    suspend fun importBackup(backupJson: String) {
        try {
            val backup = Gson().fromJson(backupJson, BackupData::class.java)
            
            context.dataStore.edit { preferences ->
                preferences[PreferencesKeys.LAST_READ_PAGE] = backup.lastReadPage
                preferences[PreferencesKeys.DARK_MODE] = backup.settings.isDarkMode
                preferences[PreferencesKeys.SELECTED_RECITER] = backup.settings.selectedReciter
                preferences[PreferencesKeys.FONT_SIZE] = backup.settings.quranFontSize
                preferences[PreferencesKeys.AUTO_SCROLL] = backup.settings.enableAutoScroll
                preferences[PreferencesKeys.DAILY_MORNING_REMINDER] = backup.settings.dailyMorningReminder
                preferences[PreferencesKeys.DAILY_EVENING_REMINDER] = backup.settings.dailyEveningReminder
                preferences[PreferencesKeys.SEBHA_COUNT] = backup.sebhaCount
                preferences[PreferencesKeys.TREE_GROWTH] = backup.todayTracker.treeGrowthPercentage
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
