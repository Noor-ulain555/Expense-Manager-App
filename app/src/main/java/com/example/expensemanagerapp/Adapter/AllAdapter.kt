package com.example.expensemanagerapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.databinding.AllSampleBinding

class AllAdapter(private val context: Context, private var allList: List<IncomeEntity>) :
    RecyclerView.Adapter<AllAdapter.ViewHolder>() {
    class ViewHolder(val binding: AllSampleBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = AllSampleBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = allList[position]
        holder.binding.name.text = item.name
        holder.binding.amount.text = item.Amount.toString()
        holder.binding.date.text=item.date
    }
    override fun getItemCount(): Int {
        return allList.size
    }
    }
