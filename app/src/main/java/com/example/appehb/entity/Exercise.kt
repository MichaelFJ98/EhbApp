package com.example.appehb.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "exercise", foreignKeys = [ForeignKey(
    entity = Workout::class,
    parentColumns = ["id"],
    childColumns = ["workoutId"],
    onDelete = ForeignKey.CASCADE
)])
@Parcelize
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val workoutId: Int,
    val name: String,
    val sets: Int
) : Parcelable
