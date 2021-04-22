package com.example.diplom.view_model

import androidx.lifecycle.MutableLiveData
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.use_case.FindByCriterionUseCase
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    private val findByCriterionUseCase: FindByCriterionUseCase
): BaseViewModel() {

    val findUser = MutableLiveData<List<UserEntity>>()

    fun findUser(subject: String, city: String){
        compositeDisposable += findByCriterionUseCase.findByCriterion(subject, city)
            .subscribe{user ->
                findUser.value = user
            }
    }
}