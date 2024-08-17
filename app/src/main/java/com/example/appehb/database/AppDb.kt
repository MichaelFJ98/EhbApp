package com.example.appehb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appehb.dao.ExerciseDao
import com.example.appehb.dao.LogDao
import com.example.appehb.dao.SetDao
import com.example.appehb.dao.WorkoutDao
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.Log
import com.example.appehb.entity.Set
import com.example.appehb.entity.Workout
@Database(
    entities = [Workout::class, Exercise::class, Log::class, Set::class],
    version = 3,
)
abstract class AppDb: RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun logDao(): LogDao
    abstract fun setDao(): SetDao

    companion object{
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDb(context: Context): AppDb{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "app_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }


}