package com.example.diplom.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.diplom.R
import com.example.diplom.presentation.main.fragment.calendar.CalendarFragment
import com.example.diplom.presentation.main.fragment.message.MessageFragment
import com.example.diplom.presentation.main.fragment.profile.ProfileFragment
import com.example.diplom.presentation.main.fragment.search.SearchTeacherFragment
import com.example.diplom.presentation.registration.sign_up.SignUpChoiceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainActivity : AppCompatActivity() {

    lateinit var toolBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        teacherSearch()

        bottomNavigationMainScreen.setOnNavigationItemSelectedListener {
           when(it.itemId){
               R.id.pageSearch -> {
                   teacherSearch()
                   return@setOnNavigationItemSelectedListener true
               }
               R.id.pageMessage -> {
                   message()
                   return@setOnNavigationItemSelectedListener true
               }
               R.id.pageСalendar -> {
                   calendar()
                   return@setOnNavigationItemSelectedListener true
               }
               R.id.pageProfile -> {
                   profile()
                   return@setOnNavigationItemSelectedListener true
               }
           }
           false
        }
    }


    private fun teacherSearch() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentMainScreen, SearchTeacherFragment())
        fragmentTransaction.commit()
    }

    private fun message() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentMainScreen, MessageFragment())
        fragmentTransaction.commit()
    }

    private fun calendar() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentMainScreen, CalendarFragment())
        fragmentTransaction.commit()
    }

    private fun profile() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.caseFragmentMainScreen, ProfileFragment())
        fragmentTransaction.commit()
    }
}