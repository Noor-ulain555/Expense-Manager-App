package com.example.expensemanagerapp


import android.annotation.SuppressLint
import com.example.expensemanagerapp.Adapter.adapterincome
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.ViewModel.viewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.expensemanagerapp.Database.AppDatabase
import com.example.expensemanagerapp.databinding.FragmentSalesIncomeBinding


class salesIncomeFragment : Fragment() {
    private lateinit var binding: FragmentSalesIncomeBinding
    private lateinit var adapter: adapterincome
   private lateinit var database: AppDatabase
    private val viewModel: viewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalesIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    database = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "my-database").build()
        binding.rvIncome.layoutManager = LinearLayoutManager(requireContext())
        val incomeObserver = Observer<List<IncomeEntity>> { incomeList ->
            adapter = adapterincome(requireContext(), incomeList)

            binding.rvIncome.adapter = adapter
            adapter.notifyDataSetChanged()

        }
        viewModel.incomeData.observe(viewLifecycleOwner, incomeObserver)
    }
}


