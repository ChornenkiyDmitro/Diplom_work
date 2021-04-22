package com.example.diplom.presentation.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.diplom.R
import com.example.diplom.presentation.registration.wellcome.RegistrationFragment


class RegistrationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val fm1: FragmentManager = supportFragmentManager
        val ft1: FragmentTransaction = fm1.beginTransaction()
        ft1.replace(R.id.caseFragmentRegistration, RegistrationFragment())
        ft1.commit()
    }
}