package com.example.appehb.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "set")
@Parcelize
data class Set(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val exerciseId: Int,
    val logId: Int,
    val reps: Int,
    val weight: Int,
) : Parcelable
