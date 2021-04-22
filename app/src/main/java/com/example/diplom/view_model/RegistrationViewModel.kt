package com.example.diplom.view_model

import androidx.lifecycle.MutableLiveData
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.use_case.InsertUserUseCase
import io.reactivex.rxkotlin.plusAssign

class RegistrationViewModel(
    private val insertUserUseCase: InsertUserUseCase
): BaseViewModel() {

    private val addedUser = MutableLiveData<MainNextScreen>()
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
}