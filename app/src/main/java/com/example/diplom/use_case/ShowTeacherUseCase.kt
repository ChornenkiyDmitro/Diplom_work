package com.example.diplom.use_case

import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.repository.Repository
import io.reactivex.Single

interface ShowTeacherUseCase {
    fun showTeacher(type: Int): Single<List<UserEntity>>
}

class ShowTeacherUseCaseImpl(
        private val repository: Repository
): ShowTeacherUseCase{

    override fun showTeacher(type: Int): Single<List<UserEntity>> {
        return repository.showTeacher(type)
    }

}