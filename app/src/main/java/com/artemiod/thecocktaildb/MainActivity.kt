package com.artemiod.thecocktaildb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.artemiod.thecocktaildb.data.DataSource
import com.artemiod.thecocktaildb.databinding.ActivityMainBinding
import com.artemiod.thecocktaildb.domain.RepositoryImplement
import com.artemiod.thecocktaildb.ui.viewmodel.MainViewModel
import com.artemiod.thecocktaildb.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepositoryImplement(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonBackToTop()
    }

    // pone la flechita para volver + onSupportNavigateUp()
    private fun buttonBackToTop() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}