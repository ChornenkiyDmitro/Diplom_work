package com.example.diplom.di.module

import androidx.annotation.Keep
import com.example.diplom.view_model.MainViewModel
import com.example.diplom.view_model.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Keep
val viewModelModule = module(override = true) {
    viewModel { MainViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
}