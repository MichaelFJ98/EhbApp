package com.example.appehb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.relation.ExerciseWithSets
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Upsert
    fun upsert(exercise: Exercise)
    @Delete
    fun delete(exercise: Exercise)

    @Query("SELECT * FROM exercise WHERE id = :exerciseId")
    fun getAllSetsForExercise(exerciseId: Int): Flow<List<ExerciseWithSets>>
}