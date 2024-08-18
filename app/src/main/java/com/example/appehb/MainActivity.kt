package com.example.appehb

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.appehb.database.AppDb
import com.example.appehb.database.repository.ExerciseRepository
import com.example.appehb.database.repository.LogRepository
import com.example.appehb.database.repository.SetRepository
import com.example.appehb.database.repository.WorkoutRepository
import com.example.appehb.databinding.ActivityMainBinding
import com.example.appehb.ui.exercise.ExerciseViewModel
import com.example.appehb.ui.exercise.ExerciseViewModelProviderFactory
import com.example.appehb.ui.log.LogViewModel
import com.example.appehb.ui.log.LogViewModelProviderFactory
import com.example.appehb.ui.set.SetViewModel
import com.example.appehb.ui.set.SetViewModelProvider
import com.example.appehb.ui.workout.WorkoutViewModel
import com.example.appehb.ui.workout.WorkoutViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var workoutViewModel: WorkoutViewModel
    lateinit var exerciseViewModel: ExerciseViewModel
    lateinit var logViewModel: LogViewModel
    lateinit var setViewModel: SetViewModel

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
        initViewModelExercise()
        initViewModelLog()
        initViewModelSet()
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

    private fun initViewModelExercise() {
        val exerciseRepository = ExerciseRepository(AppDb(this))

        val viewModelProviderFactory =
            ExerciseViewModelProviderFactory(
                application, exerciseRepository
            )

        exerciseViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory,
        )[ExerciseViewModel::class.java]
    }

    private fun initViewModelLog() {
        val logRepository = LogRepository(AppDb(this))

        val viewModelProviderFactory =
            LogViewModelProviderFactory(
                application, logRepository
            )

        logViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory,
        )[LogViewModel::class.java]
    }

    private fun initViewModelSet() {
        val setRepository = SetRepository(AppDb(this))

        val viewModelProviderFactory =
            SetViewModelProvider(
                application, setRepository
            )

        setViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory,
        )[SetViewModel::class.java]
    }
}