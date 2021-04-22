package com.example.diplom.di.bilder

import com.example.diplom.repository.Repository
import com.example.diplom.use_case.FindByCriterionUseCase
import com.example.diplom.use_case.FindByCriterionUseCaseImpl
import com.example.diplom.use_case.InsertUserUseCase
import com.example.diplom.use_case.InsertUserUseCaseImpl

class UseCaseBuilder {

    fun initFindByCriterionUseCase(repository: Repository):
            FindByCriterionUseCase = FindByCriterionUseCaseImpl(repository)

    fun initInsertUserUseCase(repository: Repository):
            InsertUserUseCase = InsertUserUseCaseImpl(repository)
}