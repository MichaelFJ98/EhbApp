package com.example.appehb.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.Set


data class ExerciseWithSets(
    @Embedded
    val exercise: Exercise,
    @Relation(
        parentColumn = "id",
        entityColumn = "exerciseId"
    )
    val sets: List<Set>
)
