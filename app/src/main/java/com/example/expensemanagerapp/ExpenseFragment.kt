package com.example.expensemanagerapp

import android.annotation.SuppressLint
import com.example.expensemanagerapp.Adapter.ExpenseAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.ViewModel.viewModel
import com.example.expensemanagerapp.databinding.FragmentExpenseBinding

class ExpenseFragment : Fragment() {
    private lateinit var binding: FragmentExpenseBinding
    private lateinit var adapter: ExpenseAdapter
    private val viewmodel: viewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.expenseRv.layoutManager = LinearLayoutManager(requireContext())
        val expenseObserver = Observer<List<IncomeEntity>> { expenseList ->
            adapter = ExpenseAdapter(requireContext(), expenseList)

            binding.expenseRv.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        viewmodel.expenseData.observe(viewLifecycleOwner, expenseObserver)
    }
}

