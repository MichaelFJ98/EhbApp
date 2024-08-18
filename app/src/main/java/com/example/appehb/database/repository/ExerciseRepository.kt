package com.example.appehb.database.repository

import com.example.appehb.database.AppDb
import com.example.appehb.entity.Exercise

class ExerciseRepository(private val db: AppDb) {
    suspend fun insertExercise(exercise: Exercise) =
        db.exerciseDao().insert(exercise)

    suspend fun updateExercise(exercise: Exercise) =
        db.exerciseDao().update(exercise)

    suspend fun deleteExercise(exercise: Exercise) =
        db.exerciseDao().delete(exercise)

    fun getSetsForExercise(id: Int) =
        db.exerciseDao().getAllSetsForExercise(id)
}