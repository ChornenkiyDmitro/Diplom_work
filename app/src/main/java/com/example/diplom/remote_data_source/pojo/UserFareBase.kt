package com.example.diplom.remote_data_source.pojo

import androidx.room.ColumnInfo

data class UserFareBase
    (
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