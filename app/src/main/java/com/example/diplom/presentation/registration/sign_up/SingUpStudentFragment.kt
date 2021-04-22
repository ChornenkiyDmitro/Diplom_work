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
            val userInsert = UserEntity(
                0,
                1,
                email,
                name,
                surname,
                pass,
                city,
                "nothing"
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
        nextScreen.putExtra("typeUser", 1)
        startActivity(nextScreen)
    }
}