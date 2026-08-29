package com.jannat.alrahman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jannat.alrahman.databinding.ActivityAthkarBinding

class AthkarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAthkarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAthkarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // إعداد شريط الأدوات
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "الأذكار"
            setDisplayHomeAsUpEnabled(true)
        }

        // تحميل الأذكار
        loadAthkar()
    }

    private fun loadAthkar() {
        // تحميل الأذكار من البيانات
        val athkar = listOf(
            "أذكار الصباح",
            "أذكار المساء",
            "أذكار النوم",
            "أذكار الاستيقاظ",
            "أذكار الطعام",
            "أذكار ما بعد الصلاة"
        )

        // عرض الأذكار
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
