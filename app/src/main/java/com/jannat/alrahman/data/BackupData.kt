package com.jannat.alrahman.data

import com.google.gson.annotations.SerializedName

data class BackupData(
    @SerializedName("exportedAt")
    val exportedAt: String,
    
    @SerializedName("settings")
    val settings: Settings,
    
    @SerializedName("bookmarks")
    val bookmarks: List<Bookmark>,
    
    @SerializedName("lastReadPage")
    val lastReadPage: Int,
    
    @SerializedName("todayTracker")
    val todayTracker: TodayTracker,
    
    @SerializedName("sebhaCount")
    val sebhaCount: Int,
    
    @SerializedName("favoriteScholars")
    val favoriteScholars: List<String>
)

data class Settings(
    @SerializedName("isDarkMode")
    val isDarkMode: Boolean,
    
    @SerializedName("selectedReciter")
    val selectedReciter: String,
    
    @SerializedName("quranFontSize")
    val quranFontSize: Int,
    
    @SerializedName("enableAutoScroll")
    val enableAutoScroll: Boolean,
    
    @SerializedName("dailyMorningReminder")
    val dailyMorningReminder: Boolean,
    
    @SerializedName("dailyEveningReminder")
    val dailyEveningReminder: Boolean
)

data class Bookmark(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("type")
    val type: String,
    
    @SerializedName("title")
    val title: String,
    
    @SerializedName("subtitle")
    val subtitle: String,
    
    @SerializedName("targetId")
    val targetId: Int
)

data class TodayTracker(
    @SerializedName("date")
    val date: String,
    
    @SerializedName("prayers")
    val prayers: Map<String, String>,
    
    @SerializedName("quranPagesRead")
    val quranPagesRead: Int,
    
    @SerializedName("quranTargetPages")
    val quranTargetPages: Int,
    
    @SerializedName("athkarCompletedCount")
    val athkarCompletedCount: Int,
    
    @SerializedName("athkarTargetCount")
    val athkarTargetCount: Int,
    
    @SerializedName("treeGrowthPercentage")
    val treeGrowthPercentage: Int
)
