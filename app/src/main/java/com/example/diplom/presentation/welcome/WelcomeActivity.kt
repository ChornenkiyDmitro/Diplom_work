package com.example.diplom.presentation.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diplom.R
import com.example.diplom.presentation.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        textSignIn.setOnClickListener{
            val singIn = Intent(this@WelcomeActivity, RegistrationActivity::class.java)
            singIn.putExtra("frgToLoad", 1)
            startActivity(singIn)
        }

        textSignUp.setOnClickListener {
            val singUp = Intent(this@WelcomeActivity, RegistrationActivity::class.java)
            singUp.putExtra("frgToLoad", 2)
            startActivity(singUp)
        }
    }
}