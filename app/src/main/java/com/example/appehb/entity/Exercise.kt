package com.example.appehb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val workoutId: Int,
    val name: String,
    val sets: Int
)
