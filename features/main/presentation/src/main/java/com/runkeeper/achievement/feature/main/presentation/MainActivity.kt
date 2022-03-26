package com.runkeeper.achievement.feature.main.presentation

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.runkeeper.achievement.feature.main.presentation.R
import com.runkeeper.achievement.feature.main.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init() {
        initNavigation()
        setToolbar()
    }

    private fun initNavigation() {
        navHostFragment =
            (supportFragmentManager.findFragmentById(R.id.fragment_navigation_container)
                    as NavHostFragment)

        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

    }

    private fun setToolbar() {
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_bar_menu, menu)
        return true
    }

}