package com.jannat.alrahman.data

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey

val Context.dataStore by preferencesDataStore(name = "jannat_alrahman_prefs")

object PreferencesKeys {
    val LAST_READ_PAGE = intPreferencesKey("last_read_page")
    val DARK_MODE = booleanPreferencesKey("dark_mode")
    val SELECTED_RECITER = stringPreferencesKey("selected_reciter")
    val FONT_SIZE = intPreferencesKey("font_size")
    val AUTO_SCROLL = booleanPreferencesKey("auto_scroll")
    val DAILY_MORNING_REMINDER = booleanPreferencesKey("daily_morning_reminder")
    val DAILY_EVENING_REMINDER = booleanPreferencesKey("daily_evening_reminder")
    val SEBHA_COUNT = intPreferencesKey("sebha_count")
    val TREE_GROWTH = intPreferencesKey("tree_growth")
}
