package com.example.diplom.data_source.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

    @PrimaryKey(autoGenerate = false)
    val id: String,

    @ColumnInfo(name = "type")
    val type: Int,

    @ColumnInfo(name= "email")
    val email: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "surname")
    val surname: String,

    @ColumnInfo(name = "pass")
    val pass: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "subject")
    val subject: String
)