package com.example.diplom.presentation.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.diplom.R
import com.example.diplom.presentation.registration.listener.OnFragmentChangeListener
import com.example.diplom.presentation.registration.sign_in.SignInFragment
import com.example.diplom.presentation.registration.sign_up.SignUpChoiceFragment
import com.example.diplom.presentation.registration.sign_up.SignUpTeacherFragment
import com.example.diplom.presentation.registration.sign_up.SingUpStudentFragment
import com.example.diplom.presentation.registration.wellcome.RegistrationFragment


class RegistrationActivity: AppCompatActivity(), OnFragmentChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        startRegistration()
    }

    private fun startRegistration(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentRegistration, RegistrationFragment())
        fragmentTransaction.commit()
    }

    private fun choiceSignUp(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentRegistration, SignUpChoiceFragment())
        fragmentTransaction.commit()
    }

    private fun studentSignUp(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentRegistration, SingUpStudentFragment())
        fragmentTransaction.commit()
    }

    private fun teacherSignUp(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentRegistration, SignUpTeacherFragment())
        fragmentTransaction.commit()
    }

    private fun signIn(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentRegistration, SignInFragment())
        fragmentTransaction.commit()
    }

    override fun onRout(choice: String) {
        when (choice) {
            "sign in" -> signIn()
            "sign up" -> choiceSignUp()
            "teacher" -> teacherSignUp()
            "student" -> studentSignUp()
        }
    }
}