package com.example.expensemanagerapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income")
data class IncomeEntity(
        var name: String,
        var Amount: Double,
        var isIncome:Boolean,
        var date: String,
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0, )