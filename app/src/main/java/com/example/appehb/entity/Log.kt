package com.example.appehb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.Duration


@Entity(tableName = "log")
data class Log(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "w_id")
    val wId: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "duration")
    val duration: Int
)

