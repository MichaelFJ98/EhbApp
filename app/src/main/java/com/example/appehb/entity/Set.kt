package com.example.appehb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "set")
data class Set(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val exerciseId: Int,
    val logId: Int,
    val reps: Int,
    val weight: Int,
)
