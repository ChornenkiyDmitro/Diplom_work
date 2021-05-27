package com.example.diplom.presentation.registration.sign_in

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.diplom.R
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.presentation.main.MainActivity
import com.example.diplom.presentation.welcome.WelcomeActivity
import com.example.diplom.view_model.RegistrationViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sing_up_teacher.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment: Fragment() {

    val registrationViewModel: RegistrationViewModel? by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sign_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSingIn.setOnClickListener {
            takeUserAndGo()
        }
    }

    private fun takeUserAndGo(){

        val email = edittextEmail.text.toString()
        val pass = edittextPassword.text.toString()

        if (inputCheck(email, pass)){

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(activity, "User is real", Toast.LENGTH_SHORT)
                            .show()
                        goNextScreen()
                    } else {
                        Toast.makeText(activity, "Error, check the date", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        } else {
            Toast.makeText(activity, "Error, email or pass is empty", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(email: String, pass: String): Boolean {
        return email.isNotEmpty() && pass.isNotEmpty()
    }

    private fun goNextScreen(){
        val nextScreen = Intent (activity, MainActivity::class.java)
        startActivity(nextScreen)
    }
}