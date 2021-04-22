package com.example.diplom.use_case

import com.example.diplom.data_source.database.entity.UserEntity
import com.example.diplom.repository.Repository
import io.reactivex.Single

interface FindByCriterionUseCase {
   fun findByCriterion(subject: String, city: String): Single<List<UserEntity>>
}

class FindByCriterionUseCaseImpl(
    private val repository: Repository
): FindByCriterionUseCase{

    override fun findByCriterion(subject: String, city: String): Single<List<UserEntity>> {
        return  repository.findByCriterion(subject, city)
    }

}