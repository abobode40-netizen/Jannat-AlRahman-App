package com.jannat.alrahman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jannat.alrahman.databinding.ActivityTreeBinding

class TreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // إعداد شريط الأدوات
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "شجرة العبادات"
            setDisplayHomeAsUpEnabled(true)
        }

        // تحميل حالة الشجرة
        loadTreeStatus()
    }

    private fun loadTreeStatus() {
        // عرض حالة نمو الشجرة
        val treeGrowthPercentage = 0 // من البيانات المحفوظة
        // عرض رسم الشجرة بناءً على نسبة النمو
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
