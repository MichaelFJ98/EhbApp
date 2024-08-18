package com.example.appehb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.appehb.entity.Set
import kotlinx.coroutines.flow.Flow


@Dao
interface SetDao {
    @Upsert
    fun upsert(set: Set)
    @Delete
    fun delete(set: Set)
    @Query("SELECT * FROM `set` WHERE id = :id")
    fun getSetById(id: Int): Flow<Set>
}