package com.amaeschiffer.moviedb.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.amaeschiffer.moviedb.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        window.setFlags(
            android.R.attr.windowFullscreen,
            android.R.attr.windowFullscreen)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }, 3000)
    }
}