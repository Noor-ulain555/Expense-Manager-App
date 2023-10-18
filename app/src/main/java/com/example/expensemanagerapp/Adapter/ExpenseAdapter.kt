package com.example.expensemanagerapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.databinding.ExpenseSampleBinding

class ExpenseAdapter(private val context: Context, private var expenseList: List<IncomeEntity>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {
    class ViewHolder(val binding: ExpenseSampleBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ExpenseSampleBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return expenseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = expenseList[position]
        holder.binding.name.text = item.name
        holder.binding.amount.text = item.Amount.toString()
        holder.binding.date.text = item.date
    }
}

