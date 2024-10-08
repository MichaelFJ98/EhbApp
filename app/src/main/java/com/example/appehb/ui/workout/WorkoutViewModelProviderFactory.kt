package com.example.appehb.ui.workout

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appehb.database.repository.WorkoutRepository

class WorkoutViewModelProviderFactory(
    val app: Application,
    private val workoutRepository: WorkoutRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WorkoutViewModel(app, workoutRepository) as T
    }
}