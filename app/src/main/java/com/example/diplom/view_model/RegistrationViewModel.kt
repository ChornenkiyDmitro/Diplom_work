package com.example.diplom.view_model

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.use_case.InsertUserUseCase
import com.example.diplom.use_case.SignInUserUseCase
import io.reactivex.rxkotlin.plusAssign

class RegistrationViewModel(
    private val insertUserUseCase: InsertUserUseCase,
    private val signInUserUseCase: SignInUserUseCase
): BaseViewModel() {

    private val addedUser = MutableLiveData<MainNextScreen>()
    val checkedUser = MutableLiveData<UserEntity>()
    private val errorMessage = MutableLiveData<String>()

    enum class MainNextScreen{
        DEFAULT, LIST_ACTIVITY
    }

    fun insertUser(user: UserEntity){
        compositeDisposable += insertUserUseCase.insertUser(user)
            .subscribe({
                addedUser.value = MainNextScreen.LIST_ACTIVITY
            }, {error ->
                addedUser.value = MainNextScreen.DEFAULT
                errorMessage.value = error.message
            })
    }

    fun checkUser(email: String, pass: String){
        compositeDisposable += signInUserUseCase.signInUser(email, pass)
                .subscribe({checkUser ->
                    checkedUser.value = checkUser
                }, {error ->
                    addedUser.value = MainNextScreen.DEFAULT
                    errorMessage.value = error.message
                })
    }
}