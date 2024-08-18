package com.example.appehb.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.appehb.entity.Log
import com.example.appehb.entity.Workout

data class WorkoutWithLogs(
    @Embedded
    val workout: Workout,
    @Relation(
        parentColumn = "id",
        entityColumn = "workoutId"
    )
    val logs: List<Log>
)
