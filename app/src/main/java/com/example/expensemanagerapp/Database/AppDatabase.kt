package com.example.expensemanagerapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensemanagerapp.DAO.IncomeDao
import com.example.expensemanagerapp.Model.IncomeEntity

@Database(entities = [IncomeEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getIDao(): IncomeDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "my-database").build()
                }
            }
            return instance!!
        }
    }
}

