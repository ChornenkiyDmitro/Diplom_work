package com.example.diplom.data_source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.diplom.data_source.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT* FROM user WHERE subject LIKE :subject AND city LIKE :city")
    fun findByCriterion(subject: String, city: String): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : UserEntity)
}