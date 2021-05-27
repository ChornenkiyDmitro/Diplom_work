package com.example.diplom.presentation.registration.sign_up

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.presentation.main.MainActivity
import com.example.diplom.presentation.welcome.WelcomeActivity
import com.example.diplom.remote_data_source.pojo.UserFareBase
import com.example.diplom.view_model.RegistrationViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_sing_up_student.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingUpStudentFragment: Fragment() {

    val registrationViewModel: RegistrationViewModel? by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sing_up_student, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSingUpStudent.setOnClickListener { addStudent() }
    }

    fun addStudent(){
        val email = edittextEmailS.text.toString()
        val name = edittextNameS.text.toString()
        val surname = edittextSurNameS.text.toString()
        val pass = edittextPasswordS.text.toString()
        val city = spinnerCityS.getSelectedItem().toString()

        if (inputCheck(name, surname, email, pass)){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val userInsert = UserFareBase(
                        1,
                        email,
                        name,
                        surname,
                        pass,
                        city,
                        "nothing"
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

        }
    }

    private fun inputCheck(name: String, surname: String, email: String, pass: String): Boolean {
        return name.isNotEmpty() && surname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()
    }

    private fun goNextScreen(){
        val nextScreen = Intent (activity, WelcomeActivity::class.java)
        startActivity(nextScreen)
    }
}