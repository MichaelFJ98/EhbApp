package com.example.appehb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.appehb.entity.Set

@Dao
interface SetDao {
    @Insert
    suspend fun insert(set: Set)
    @Update
    suspend fun update(set: Set)
    @Delete
    suspend fun delete(set: Set)
    @Query("SELECT * FROM `set` WHERE id = :id")
    fun getSetById(id: Int): LiveData<Set>
}