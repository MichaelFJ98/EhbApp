package com.example.appehb

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appehb.database.AppDb
import com.example.appehb.database.repository.WorkoutRepository
import com.example.appehb.databinding.ActivityMainBinding
import com.example.appehb.ui.workout.WorkoutViewModel
import com.example.appehb.ui.workout.WorkoutViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var workoutViewModel: WorkoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.mobile_navigation)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

        initViewModelWorkout()
    }

    private fun initViewModelWorkout() {
        val workoutRepository = WorkoutRepository(AppDb(this))

        val viewModelProviderFactory =
            WorkoutViewModelProviderFactory(
                application, workoutRepository
            )

        workoutViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory,
        )[WorkoutViewModel::class.java]
    }
}