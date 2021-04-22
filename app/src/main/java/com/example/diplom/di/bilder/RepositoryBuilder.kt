package com.example.diplom.di.bilder

import com.example.diplom.data_source.DataSource
import com.example.diplom.remote_data_source.RemoteDataSource
import com.example.diplom.repository.Repository
import com.example.diplom.repository.RepositoryImpl

class RepositoryBuilder(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
) {
    fun initRepository(): Repository = RepositoryImpl(dataSource, remoteDataSource)
}