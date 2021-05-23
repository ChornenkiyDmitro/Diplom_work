package com.example.diplom.data_source.database.dao

import androidx.room.*
import com.example.diplom.data_source.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE type LIKE :type")
    fun showTeacher(type: Int): List<UserEntity>

    @Query("SELECT * FROM user WHERE type LIKE :type AND subject LIKE :subject AND city LIKE :city")
    fun findByCriterion(type: Int, subject: String, city: String): List<UserEntity>

    @Query("SELECT * FROM user WHERE email LIKE :email AND pass LIKE :pass")
    fun signInUser(email: String, pass: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : UserEntity)

}