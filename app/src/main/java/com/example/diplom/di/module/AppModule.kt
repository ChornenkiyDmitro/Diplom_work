package com.example.diplom.di.module

import androidx.annotation.Keep

@Keep
val appModule = listOf(
    databaseModule,
    remoteDatabaseModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)