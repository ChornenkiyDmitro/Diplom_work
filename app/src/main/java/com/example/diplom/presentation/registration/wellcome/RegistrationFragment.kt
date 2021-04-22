package com.example.diplom.presentation.registration.wellcome

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.diplom.R
import com.example.diplom.presentation.registration.listener.OnFragmentChangeListener
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment() : Fragment() {

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
    ): View = inflater.inflate(R.layout.fragment_registration, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textSignIn.setOnClickListener{
          if (listener != null) {
                listener!!.onRout("sign in")
            }
        }

        textSignUp.setOnClickListener {
             if (listener != null) {
                listener!!.onRout("sign up")
            }
        }
    }
}


