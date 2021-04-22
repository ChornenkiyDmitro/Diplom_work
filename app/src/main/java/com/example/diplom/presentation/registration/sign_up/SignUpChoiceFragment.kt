package com.example.diplom.presentation.registration.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.example.diplom.presentation.registration.listener.OnFragmentChangeListener
import kotlinx.android.synthetic.main.fragment_sign_up_choice.*
import kotlinx.android.synthetic.main.fragment_sing_up_teacher.*

class SignUpChoiceFragment : Fragment() {

    var listener: OnFragmentChangeListener? = null

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is OnFragmentChangeListener) listener =
            activity as OnFragmentChangeListener?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sign_up_choice, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonTeacher.setOnClickListener {
            if (listener != null) {
                listener!!.onRout("teacher")
            }
        }
        buttonStudent.setOnClickListener {
            if (listener != null) {
                listener!!.onRout("student")
            }
        }

    }
}