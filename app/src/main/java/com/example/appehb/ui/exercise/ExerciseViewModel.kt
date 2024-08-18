package com.example.appehb.ui.exercise

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appehb.database.repository.ExerciseRepository
import com.example.appehb.entity.Exercise
import kotlinx.coroutines.launch

class ExerciseViewModel(
    val app: Application,
    private val exerciseRepository: ExerciseRepository
) : AndroidViewModel(app) {

    fun insertExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseRepository.insertExercise(exercise)
        }
    }

    fun updateExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseRepository.updateExercise(exercise)
        }
    }

    fun deleteExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseRepository.deleteExercise(exercise)
        }
    }

    fun getSetsForExercise(id: Int) =
        exerciseRepository.getSetsForExercise(id)
}