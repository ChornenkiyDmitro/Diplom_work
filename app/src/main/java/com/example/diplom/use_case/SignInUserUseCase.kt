package com.example.diplom.use_case

import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.repository.Repository
import io.reactivex.Single

interface SignInUserUseCase {
    fun signInUser(email: String, pass: String): Single<UserEntity>
}
class SignInUserUseCaseImpl(
        private val repository: Repository
): SignInUserUseCase{

    override fun signInUser(email: String, pass: String): Single<UserEntity> {
        return repository.signInUser(email, pass)
    }
}