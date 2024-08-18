package com.example.appehb.ui.exercise

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appehb.database.repository.ExerciseRepository

class ExerciseViewModelProviderFactory(
    val app: Application,
    private val exerciseRepository: ExerciseRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExerciseViewModel(app, exerciseRepository) as T
    }
}
