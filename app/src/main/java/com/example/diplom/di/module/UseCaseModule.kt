package com.example.diplom.di.module

import androidx.annotation.Keep
import com.example.diplom.di.bilder.UseCaseBuilder
import org.koin.dsl.module

@Keep
val useCaseModule = module {
    single { UseCaseBuilder() }
    single { get<UseCaseBuilder>().initFindByCriterionUseCase(get()) }
    single { get<UseCaseBuilder>().initInsertUserUseCase(get()) }
}