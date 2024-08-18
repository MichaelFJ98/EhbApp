package com.example.appehb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.appehb.entity.Log
import com.example.appehb.entity.relation.LogWithSets


@Dao
interface LogDao {
    @Insert
    suspend fun insert(log: Log)
    @Update
    suspend fun update(log: Log)
    @Delete
    suspend fun delete(log: Log)
    @Query("SELECT * FROM log WHERE id = :id")
    fun getLogById(id: Int): LiveData<Log>
    @Transaction
    @Query("SELECT * FROM log WHERE id = :id")
    fun getSetsByLogId(id: Int): LiveData<List<LogWithSets>>
}