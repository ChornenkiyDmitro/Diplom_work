package com.example.diplom.presentation.registration.sign_up

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.example.diplom.presentation.welcome.WelcomeActivity
import com.example.diplom.remote_data_source.pojo.UserFareBase
import com.example.diplom.view_model.RegistrationViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_sing_up_teacher.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpTeacherFragment: Fragment() {

    val registrationViewModel: RegistrationViewModel? by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sing_up_teacher, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSingUpTeacher.setOnClickListener { addTeacher() }
    }

    private fun addTeacher(){
        val email = edittextEmailT.text.toString().trim()
        val name = edittextNameT.text.toString().trim()
        val surname = edittextSurNameT.text.toString().trim()
        val pass = edittextPasswordT.text.toString().trim()
        val city = spinnerCityT.getSelectedItem().toString().trim()
        val subject = spinnerSubjectsT.getSelectedItem().toString().trim()

        if (validate(name, surname, email, pass)){

          FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val userInsert = UserFareBase(
                            2,
                            email,
                            name,
                            surname,
                            pass,
                            city,
                            subject
                        )

                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid)
                            .setValue(userInsert).addOnCompleteListener {
                                if (it.isSuccessful){
                                    Toast.makeText(activity, "User is added", Toast.LENGTH_LONG)
                                        .show()
                                    goNextScreen()
                                } else{
                                    Toast.makeText(activity, "Try again", Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                    } else{
                        Toast.makeText(activity, "Try again", Toast.LENGTH_LONG)
                            .show()
                    }
                }

        } else{
            Toast.makeText(activity, "Enter all data", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validate(name: String, surname: String, email: String, pass: String): Boolean {
        return name.isNotEmpty() && surname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()
    }

    private fun goNextScreen(){
        val nextScreen = Intent (activity, WelcomeActivity::class.java)
        startActivity(nextScreen)
    }
}