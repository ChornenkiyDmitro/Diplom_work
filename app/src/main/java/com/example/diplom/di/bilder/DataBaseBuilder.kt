package com.example.diplom.di.bilder

import android.content.Context
import androidx.room.Room
import com.example.diplom.data_source.DataSource
import com.example.diplom.data_source.DataSourceImpl
import com.example.diplom.data_source.database.AppDataBase

class DataBaseBuilder (private val context: Context){

    fun initDatabase(): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "user_database"
    )
        .allowMainThreadQueries()
        .build()

    fun getDataSource(dataBase: AppDataBase): DataSource = DataSourceImpl(dataBase)
}