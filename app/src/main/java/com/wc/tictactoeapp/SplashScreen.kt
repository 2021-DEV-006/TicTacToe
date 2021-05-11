package com.wc.tictactoeapp

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class SplashScreen : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            window.requestFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
            setContentView(R.layout.splash_screen)

            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
            }, 3000)
    }
}