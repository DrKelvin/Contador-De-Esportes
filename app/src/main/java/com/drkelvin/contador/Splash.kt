package com.drkelvin.contador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Esconder o tittle name
        supportActionBar?.hide()

        // Esconder a barra de notificações e deixar em fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash, Home::class.java)
            startActivity(intent)
            finish()
            }, 5000) // delay de 5000 milisegundos, o que dá 5 segundos
    }
}

