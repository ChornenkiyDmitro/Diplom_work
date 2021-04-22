package com.example.diplom.di.module

import androidx.annotation.Keep
import com.example.diplom.di.bilder.DataBaseBuilder
import org.koin.dsl.module

@Keep
val databaseModule = module {
    single { DataBaseBuilder(get()) }
    single { get<DataBaseBuilder>().initDatabase() }
    single { get<DataBaseBuilder>().getDataSource(get()) }
}