package com.example.diplom.presentation.registration.sign_up

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.presentation.main.MainActivity
import com.example.diplom.view_model.RegistrationViewModel
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
        val email = edittextEmailT.text.toString()
        val name = edittextNameT.text.toString()
        val surname = edittextSurNameT.text.toString()
        val pass = edittextPasswordT.text.toString()
        val city = spinnerCityT.getSelectedItem().toString()
        val subject = spinnerSubjectsT.getSelectedItem().toString()

        if (inputCheck(name, surname, email, pass)){
            val userInsert = UserEntity(
                0,
                2,
                email,
                name,
                surname,
                pass,
                city,
                subject
            )
            registrationViewModel?.insertUser(userInsert)

            goNextScreen()
        }
    }

    private fun inputCheck(name: String, surname: String, email: String, pass: String): Boolean {
        return !(TextUtils.isEmpty(name)
                && TextUtils.isEmpty(surname)
                && TextUtils.isEmpty(email)
                && TextUtils.isEmpty(pass))
    }

    private fun goNextScreen(){
        val nextScreen = Intent (activity, MainActivity::class.java)
        nextScreen.putExtra("typeUser", 2)
        startActivity(nextScreen)
    }
}