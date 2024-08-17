package com.example.appehb.database.repository

import androidx.annotation.WorkerThread
import com.example.appehb.dao.WorkoutDao
import com.example.appehb.entity.Workout
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(private val workoutDao: WorkoutDao) {

    val allWorkouts: Flow<List<Workout>> = workoutDao.getAllWorkouts()
    @WorkerThread
    fun upsertWorkout(workout: Workout){
        workoutDao.upsert(workout)
    }

    @WorkerThread
    fun deleteWorkout(workout: Workout){
        workoutDao.delete(workout)
    }
}