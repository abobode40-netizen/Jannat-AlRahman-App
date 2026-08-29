package com.jannat.alrahman.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.media.AudioManager
import android.media.MediaPlayer

class AudioService : Service() {
    private val binder = AudioBinder()
    private var mediaPlayer: MediaPlayer? = null
    private val audioManager by lazy { getSystemService(AUDIO_SERVICE) as AudioManager }

    inner class AudioBinder : Binder() {
        fun getService(): AudioService = this@AudioService
    }

    override fun onBind(intent: Intent): IBinder = binder

    fun playAudio(filePath: String) {
        try {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    android.media.AudioAttributes.Builder()
                        .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                        .setContentType(android.media.AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
                setDataSource(filePath)
                prepare()
                start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun pauseAudio() {
        mediaPlayer?.pause()
    }

    fun resumeAudio() {
        mediaPlayer?.start()
    }

    fun stopAudio() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun isPlaying(): Boolean = mediaPlayer?.isPlaying ?: false

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
