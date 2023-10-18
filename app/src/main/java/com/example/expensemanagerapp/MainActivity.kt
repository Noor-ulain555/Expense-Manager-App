package com.example.expensemanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.expensemanagerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var NavController=findNavController(R.id.fragmentContainerView3)
        var bottomnav=binding.bottomNavigationView
        bottomnav.setupWithNavController(NavController)

        binding.floatingActionButton.setOnClickListener {
                val bottomSheet = BotttomDailogsFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
 }