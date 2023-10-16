package com.example.expensemanagerapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expensemanagerapp.Database.AppDatabase
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.Repository.Incomerepository
import kotlinx.coroutines.launch


class viewModel(application: Application) : AndroidViewModel(application) {
    private val incomeRepository: Incomerepository
    val incomeData: LiveData<List<IncomeEntity>>
    val expenseData: LiveData<List<IncomeEntity>>
    val alldata:LiveData<List<IncomeEntity>>

    init {
        val incomeDao = AppDatabase.getInstance(application).getIDao()
        incomeRepository = Incomerepository(incomeDao)
        incomeData = incomeRepository.allIncome
        expenseData = incomeRepository.allExpense
        alldata=incomeRepository.all
    }

    fun insertIncome(incomeItem: IncomeEntity) {
        viewModelScope.launch {
            incomeRepository.insert(incomeItem)
        }
    }
}