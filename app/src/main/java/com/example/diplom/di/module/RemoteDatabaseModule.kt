package com.example.diplom.di.module

import androidx.annotation.Keep
import com.example.diplom.di.bilder.RemoteDatabaseBuilder
import io.reactivex.schedulers.Schedulers.single
import org.koin.dsl.module

@Keep
val remoteDatabaseModule = module {
    single { RemoteDatabaseBuilder() }
    single { get<RemoteDatabaseBuilder>().getRemoteDataSource() }
}