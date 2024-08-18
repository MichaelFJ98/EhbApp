package com.example.appehb.ui.workout

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.viewModelScope
import com.example.appehb.database.AppDb
import com.example.appehb.database.repository.WorkoutRepository
import com.example.appehb.entity.Workout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class WorkoutViewModel(
    app: Application,
    private val workoutRepository: WorkoutRepository
) : AndroidViewModel(app) {

    fun insertWorkout(workout: Workout) =
        viewModelScope.launch {
            workoutRepository.insertWorkout(workout)
        }

    fun updateWorkout(workout: Workout) =
        viewModelScope.launch {
            workoutRepository.updateWorkout(workout)
        }

    fun deleteWorkout(workout: Workout) =
        viewModelScope.launch {
            workoutRepository.deleteWorkout(workout)
        }

    fun getWorkouts() =
        workoutRepository.getWorkouts()

    fun getWorkout(id: Int) =
        workoutRepository.getWorkout(id)

    fun getExercisesForWorkout(id: Int) =
        workoutRepository.getExercisesForWorkout(id)




}