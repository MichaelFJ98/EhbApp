package com.example.appehb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.appehb.entity.Workout
import com.example.appehb.entity.relation.WorkoutWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Upsert
    fun upsert(workout: Workout)
    @Delete
    fun delete(workout: Workout)
    @Query("SELECT * FROM workout ORDER BY name")
    fun getAllWorkouts(): Flow<List<Workout>>

    @Query("SELECT * FROM workout WHERE id = :id")
    fun getWorkoutById(id: Int): Workout
    @Transaction
    @Query("SELECT * FROM workout WHERE id = :id")
    fun getExercisesForWorkout(id: Int): List<WorkoutWithExercises>

}