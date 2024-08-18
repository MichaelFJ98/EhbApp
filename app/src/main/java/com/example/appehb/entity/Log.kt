package com.example.appehb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "log")
data class Log(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val workoutId: Int,
    val date: String,
    val duration: Int
)

