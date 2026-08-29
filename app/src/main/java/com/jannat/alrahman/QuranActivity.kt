package com.jannat.alrahman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jannat.alrahman.databinding.ActivityQuranBinding

class QuranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // إعداد شريط الأدوات
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "القرآن الكريم"
            setDisplayHomeAsUpEnabled(true)
        }

        // تحميل قائمة السور
        loadSurahs()
    }

    private fun loadSurahs() {
        // يتم تحميل السور من API أو من البيانات المحلية
        val surahs = listOf(
            "الفاتحة",
            "البقرة",
            "آل عمران",
            "النساء",
            "المائدة",
            "الأنعام",
            "الأعراف",
            "الأنفال",
            "التوبة",
            "يونس"
        )

        // عرض السور في RecyclerView
        // (سيتم إضافة التفاصيل لاحقاً)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
