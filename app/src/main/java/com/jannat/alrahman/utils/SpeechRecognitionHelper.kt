package com.jannat.alrahman.utils

import android.content.Context
import android.os.Build
import android.speech.SpeechRecognizer
import android.content.Intent
import android.speech.RecognizerIntent
import java.util.*

object SpeechRecognitionHelper {
    
    fun isSpeechRecognitionAvailable(context: Context): Boolean {
        return SpeechRecognizer.isRecognitionAvailable(context)
    }
    
    fun startListening(context: Context, locale: Locale = Locale("ar", "SA")): Intent {
        return Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, locale)
            putExtra(RecognizerIntent.EXTRA_PROMPT, "تحدث الآن...")
        }
    }
}
