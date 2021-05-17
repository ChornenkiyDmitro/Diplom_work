package com.example.diplom.view_model

import androidx.lifecycle.MutableLiveData
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.use_case.FindByCriterionUseCase
import com.example.diplom.use_case.ShowTeacherUseCase
import io.reactivex.rxkotlin.plusAssign

class
MainViewModel(
    private val findByCriterionUseCase: FindByCriterionUseCase,
    private val showTeacherUseCase: ShowTeacherUseCase
): BaseViewModel() {

    val findUser = MutableLiveData<List<UserEntity>>()

    fun findUser(type: Int, subject: String, city: String){
        compositeDisposable += findByCriterionUseCase.findByCriterion(type, subject, city)
            .subscribe{user ->
                findUser.value = user
            }
    }

    fun showTeacher(type: Int){
        compositeDisposable += showTeacherUseCase.showTeacher(type)
                .subscribe{user ->
                    findUser.value = user
                }
    }
}