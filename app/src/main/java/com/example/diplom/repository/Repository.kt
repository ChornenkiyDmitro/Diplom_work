package com.example.diplom.repository

import com.example.diplom.data_source.DataSource
import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single

interface Repository {

    fun findByCriterion(subject: String, city: String): Single<List<UserEntity>>
    fun insertUser(user: UserEntity): Completable

}

class RepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
): Repository{
    override fun findByCriterion(subject: String, city: String): Single<List<UserEntity>> {
        return dataSource.findByCriterion(subject, city)
    }

    override fun insertUser(user: UserEntity): Completable {
        return dataSource.insertUser(user)
    }

}