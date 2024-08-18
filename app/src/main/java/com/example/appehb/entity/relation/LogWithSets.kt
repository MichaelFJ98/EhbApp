package com.example.appehb.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.appehb.entity.Log
import com.example.appehb.entity.Set

data class LogWithSets(
    @Embedded val log: Log,
    @Relation(
        parentColumn = "id",
        entityColumn = "logId",
    )
    val sets: List<Set>
)
