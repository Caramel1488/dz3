package com.example.dz3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.databinding.ActivityMainBinding
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = Navigation.findNavController(this, R.id.fragment2)
        NavigationUI.setupWithNavController(binding.bottomNavigationBar, navController)
    }







}