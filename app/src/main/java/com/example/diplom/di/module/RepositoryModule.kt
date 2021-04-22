package com.example.diplom.di.module

import androidx.annotation.Keep
import com.example.diplom.di.bilder.RepositoryBuilder
import com.example.diplom.repository.Repository
import org.koin.dsl.module

@Keep
val repositoryModule = module {
    single { RepositoryBuilder(get(), get()) }
    single { get<RepositoryBuilder>().initRepository() }
}