package com.jerry.poterology.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jerry.poterology.MainActivity
import com.jerry.poterology.R

class Splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed( {
            val i = Intent(this, HomeScreen::class.java)
            startActivity(i)
            finish()
        },2000)
    }

}
