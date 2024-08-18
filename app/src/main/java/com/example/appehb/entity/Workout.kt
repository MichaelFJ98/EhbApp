package com.example.appehb.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "workout")
@Parcelize
data class Workout(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String
) : Parcelable
