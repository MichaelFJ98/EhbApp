package com.example.appehb.database.repository

import com.example.appehb.database.AppDb

class SetRepository(private val db: AppDb) {
    suspend fun insertSet(set: com.example.appehb.entity.Set) =
        db.setDao().insert(set)

    suspend fun updateSet(set: com.example.appehb.entity.Set) =
        db.setDao().update(set)

    suspend fun deleteSet(set: com.example.appehb.entity.Set) =
        db.setDao().delete(set)

    fun getSetById(id: Int) =
        db.setDao().getSetById(id)
}