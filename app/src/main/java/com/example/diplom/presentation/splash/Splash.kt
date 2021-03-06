package com.example.diplom.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.diplom.R
import com.example.diplom.presentation.main.MainActivity
import com.example.diplom.presentation.registration.RegistrationActivity
import com.example.diplom.presentation.welcome.WelcomeActivity

class Splash: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val nextScreen = Intent(this, WelcomeActivity::class.java)
            startActivity(nextScreen)
            finish()
        }, 3000)
    }
}