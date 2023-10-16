package com.example.expensemanagerapp.DAO
import com.example.expensemanagerapp.Model.IncomeEntity
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface IncomeDao{
        @Insert
        suspend fun insert(income: IncomeEntity)
        @Query("SELECT * FROM income WHERE isIncome = 1 ORDER BY id DESC")
        fun getIncome(): LiveData<List<IncomeEntity>>

        @Query("SELECT * FROM income WHERE isIncome = 0 ORDER BY id DESC")
        fun getExpense(): LiveData<List<IncomeEntity>>

        @Query("SELECT * FROM income ")
        fun getAll(): LiveData<List<IncomeEntity>>
}