package com.example.diplom.use_case

import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.repository.Repository
import io.reactivex.Completable

interface InsertUserUseCase{
    fun insertUser(user: UserEntity): Completable
}

class InsertUserUseCaseImpl(
    private val repository: Repository
): InsertUserUseCase{

    override fun insertUser(user: UserEntity): Completable {
        return repository.insertUser(user)
    }

}