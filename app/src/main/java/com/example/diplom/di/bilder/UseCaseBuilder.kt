package com.example.diplom.di.bilder

import com.example.diplom.repository.Repository
import com.example.diplom.use_case.*

class UseCaseBuilder {

    fun initFindByCriterionUseCase(repository: Repository):
            FindByCriterionUseCase = FindByCriterionUseCaseImpl(repository)

    fun initInsertUserUseCase(repository: Repository):
            InsertUserUseCase = InsertUserUseCaseImpl(repository)

    fun initShowTeacherUseCase(repository: Repository):
            ShowTeacherUseCase =ShowTeacherUseCaseImpl(repository)

    fun initSignInUserUseCase(repository: Repository):
            SignInUserUseCase = SignInUserUseCaseImpl(repository)
}