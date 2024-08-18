package com.example.appehb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.relation.ExerciseWithSets

@Dao
interface ExerciseDao {
    @Insert
    suspend fun insert(exercise: Exercise)

    @Update
    suspend fun update(exercise: Exercise)

    @Delete
    suspend fun delete(exercise: Exercise)

    @Transaction
    @Query("SELECT * FROM exercise WHERE id = :exerciseId")
    fun getAllSetsForExercise(exerciseId: Int): LiveData<List<ExerciseWithSets>>
}