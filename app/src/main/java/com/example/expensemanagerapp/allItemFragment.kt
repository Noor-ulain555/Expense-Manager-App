package com.example.expensemanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.expensemanagerapp.Adapter.AllAdapter
import com.example.expensemanagerapp.Database.AppDatabase
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.ViewModel.viewModel
import com.example.expensemanagerapp.databinding.FragmentAllItemBinding

class allItemFragment : Fragment() {
    private lateinit var binding: FragmentAllItemBinding
    private lateinit var database: AppDatabase
    private lateinit var Adapter: AllAdapter
    private val viewModel: viewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       database = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "my-database").build()
        binding.AllRv.layoutManager = LinearLayoutManager(requireContext())

        val allDataObserver = Observer<List<IncomeEntity>> { allDataList ->
            Adapter = AllAdapter(requireContext(), allDataList)
            binding.AllRv.adapter = Adapter
            Adapter.notifyDataSetChanged()

            val totalIncome = allDataList.filter { it.isIncome }.sumByDouble { it.Amount }
            val totalExpense = allDataList.filter { !it.isIncome }.sumByDouble { it.Amount }

            val difference = totalIncome - totalExpense

            binding.totalIncome.text = getString(R.string.total_income, totalIncome)
            binding.totalExpenseTextView.text = getString(R.string.total_expense, totalExpense)
            binding.differenceTextView.text = getString(R.string.difference, difference)
            Adapter.notifyDataSetChanged()

        }

        viewModel.alldata.observe(viewLifecycleOwner, allDataObserver)
    }
}
