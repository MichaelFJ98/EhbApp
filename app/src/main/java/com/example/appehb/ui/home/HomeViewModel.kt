package com.example.appehb.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.viewModelScope
import com.example.appehb.database.AppDb
import com.example.appehb.database.repository.WorkoutRepository
import com.example.appehb.entity.Workout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val workoutRepository: WorkoutRepository
    val workouts: Flow<List<Workout>>
    init{
        val workoutDao = AppDb.getDb(application).workoutDao()
        workoutRepository = WorkoutRepository(workoutDao)
        workouts = workoutRepository.allWorkouts
    }
    fun upsertWorkout(workout: Workout) = viewModelScope.launch {
        workoutRepository.upsertWorkout(workout)
    }
    fun deleteWorkout(workout: Workout) = viewModelScope.launch {
        workoutRepository.deleteWorkout(workout)
    }

}