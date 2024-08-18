package com.example.appehb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.appehb.entity.Log
import com.example.appehb.entity.Workout
import com.example.appehb.entity.relation.LogWithSets
import com.example.appehb.entity.relation.WorkoutWithExercises
import kotlinx.coroutines.flow.Flow


@Dao
interface LogDao {
    @Upsert
    fun upsert(log: Log)
    @Delete
    fun delete(log: Log)
    @Query("SELECT * FROM log WHERE id = :id")
    fun getLogById(id: Int): Flow<Log>
    @Transaction
    @Query("SELECT * FROM log WHERE id = :id")
    fun getSetsByLogId(id: Int): Flow<List<LogWithSets>>
}