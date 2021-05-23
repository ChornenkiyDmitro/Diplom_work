package com.example.diplom.data_source

import com.example.diplom.data_source.database.AppDataBase
import com.example.diplom.data_source.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface DataSource{

    fun showTeacher(type: Int): Single<List<UserEntity>>
    fun findByCriterion(type: Int, subject: String, city: String): Single<List<UserEntity>>
    fun insertUser(user: UserEntity): Completable
    fun signInUser(email: String, pass: String): Single<UserEntity>
}

class DataSourceImpl(private val database: AppDataBase):DataSource{

    override fun showTeacher(type: Int): Single<List<UserEntity>> {
        return Single.just(database.getUserDao().showTeacher(type))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    override fun findByCriterion(type: Int, subject: String, city: String): Single<List<UserEntity>> {
       return Single.just(database.getUserDao().findByCriterion(type, subject, city))
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
    }

    override fun insertUser(user: UserEntity): Completable {
      return Completable.fromAction {database.getUserDao().insertUser(user = user)}
          .observeOn(AndroidSchedulers.mainThread())
          .subscribeOn(Schedulers.io())
    }

    override fun signInUser(email: String, pass: String): Single<UserEntity>{
        return Single.just(database.getUserDao().signInUser(email, pass))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

}