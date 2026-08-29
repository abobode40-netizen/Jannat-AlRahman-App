package com.jannat.alrahman.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.jannat.alrahman.MainActivity
import android.app.PendingIntent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val message = intent?.getStringExtra("message") ?: "تنبيه من جنّة الرحمن"
            val alarmType = intent?.getStringExtra("type") ?: "default"

            // تشغيل رنة الإنذار
            val ringtone = RingtoneManager.getRingtone(
                context,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            )
            ringtone?.play()

            // إرسال إشعار
            sendNotification(context, message, alarmType)
        }
    }

    private fun sendNotification(context: Context, message: String, type: String) {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(context, "jannat_alrahman_notifications")
            .setContentTitle(getTitleByType(type))
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(System.currentTimeMillis().toInt(), notification)
    }

    private fun getTitleByType(type: String): String = when (type) {
        "morning" -> "أذكار الصباح"
        "evening" -> "أذكار المساء"
        "prayer" -> "موعد الصلاة"
        else -> "تنبيه من جنّة الرحمن"
    }
}
