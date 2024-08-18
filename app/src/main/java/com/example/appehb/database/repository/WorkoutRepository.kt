package com.example.appehb.database.repository

import com.example.appehb.database.AppDb
import com.example.appehb.entity.Workout

class WorkoutRepository(private val db: AppDb) {

    suspend fun insertWorkout(workout: Workout) =
        db.workoutDao().insertWorkout(workout)

    suspend fun updateWorkout(workout: Workout) =
        db.workoutDao().updateWorkout(workout)

    suspend fun deleteWorkout(workout: Workout) =
        db.workoutDao().delete(workout)

    fun getWorkouts() =
        db.workoutDao().getAllWorkouts()

    fun getWorkout(id: Int) =
        db.workoutDao().getWorkoutById(id)

    fun getExercisesForWorkout(id: Int) =
        db.workoutDao().getExercisesForWorkout(id)

}