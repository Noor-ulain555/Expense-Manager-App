package com.example.expensemanagerapp.Repository

import com.example.expensemanagerapp.Model.IncomeEntity
import androidx.lifecycle.LiveData
import com.example.expensemanagerapp.DAO.IncomeDao


class Incomerepository(private val incomeDao: IncomeDao) {
        val allIncome: LiveData<List<IncomeEntity>> = incomeDao.getIncome()
    val allExpense: LiveData<List<IncomeEntity>> = incomeDao.getExpense()
    val all: LiveData<List<IncomeEntity>> = incomeDao.getAll()


    suspend fun insert(incomeItem: IncomeEntity) {
            incomeDao.insert(incomeItem)
    }
}


