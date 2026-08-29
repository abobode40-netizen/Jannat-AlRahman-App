package com.jannat.alrahman

import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        
        // عرض شاشة البداية لمدة 2 ثانية ثم الانتقال لـ MainActivity
        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
            val intent = android.content.Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
