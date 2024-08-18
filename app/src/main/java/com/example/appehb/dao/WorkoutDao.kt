package com.example.appehb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.appehb.entity.Workout
import com.example.appehb.entity.relation.WorkoutWithExercises

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: Workout)
    @Update
    suspend fun updateWorkout(workout: Workout)
    @Delete
    suspend fun delete(workout: Workout)
    @Query("SELECT * FROM workout ORDER BY name")
    fun getAllWorkouts(): LiveData<List<Workout>>

    @Query("SELECT * FROM workout WHERE id = :id")
    fun getWorkoutById(id: Int): LiveData<Workout>
    @Transaction
    @Query("SELECT * FROM workout WHERE id = :id")
    fun getExercisesForWorkout(id: Int): LiveData<List<WorkoutWithExercises>>

}