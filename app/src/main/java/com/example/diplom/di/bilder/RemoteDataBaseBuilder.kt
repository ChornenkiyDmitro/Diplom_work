package com.example.diplom.di.bilder

import com.example.diplom.remote_data_source.RemoteDataSource
import com.example.diplom.remote_data_source.RemoteDataSourceImpl

class RemoteDatabaseBuilder{

    fun getRemoteDataSource(): RemoteDataSource = RemoteDataSourceImpl()
}