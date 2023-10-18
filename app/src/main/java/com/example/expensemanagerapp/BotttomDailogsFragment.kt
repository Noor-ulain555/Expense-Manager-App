package com.example.expensemanagerapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.expensemanagerapp.Database.AppDatabase
import com.example.expensemanagerapp.Model.IncomeEntity
import com.example.expensemanagerapp.ViewModel.viewModel
import com.example.expensemanagerapp.databinding.FragmentBotttomDailogssBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.Calendar

class BotttomDailogsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBotttomDailogssBinding
    private val viewModel: viewModel by viewModels()
    private lateinit var database: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBotttomDailogssBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "my-database"
        ).build()
        binding.date.setOnClickListener {
            showDatePickerDialog()
        }
        binding.saveIm.setOnClickListener {
            val name = binding.nameTv.text.toString()
            val amount = binding.AmountTv.text.toString().toDouble()
            val date = binding.dateI.text.toString()
            val isIncome = binding.rbIncome.isChecked
            val isExpense = binding.rbExpense.isChecked
            if (isIncome || isExpense) {
                if (name.isNotEmpty() && amount > 0 && date.isNotEmpty()) {
                    lifecycleScope.launch(Dispatchers.IO) {
                        val item = IncomeEntity(name, amount, isIncome, date)
                        viewModel.insertIncome(item)
                    }
                    dismiss()
                } else {
                    Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please select either Income or Expense", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                c.set(year, monthOfYear, dayOfMonth)
                val selectedDate = DateFormat.getDateInstance().format(c.time)
                binding.dateI.text = selectedDate
            }, year, month, day
        )
        datePickerDialog.show()
    }
}
