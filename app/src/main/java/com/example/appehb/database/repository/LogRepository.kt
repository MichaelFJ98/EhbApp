package com.example.appehb.database.repository

import com.example.appehb.database.AppDb
import com.example.appehb.entity.Log

class LogRepository (private val db: AppDb) {

    suspend fun insertLog(log: Log) =
        db.logDao().insert(log)

    suspend fun updateLog(log: Log) =
        db.logDao().update(log)

    suspend fun deleteLog(log: Log) =
        db.logDao().delete(log)

    fun getLogsById(id: Int) =
        db.logDao().getLogById(id)

    fun getSetsByLogId(id: Int) =
        db.logDao().getSetsByLogId(id)
}