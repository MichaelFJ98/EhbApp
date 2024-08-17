package com.example.appehb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "w_id")
    val wId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sets")
    val sets: Int
)
