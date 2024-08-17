package com.example.appehb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.appehb.entity.Workout
import com.example.appehb.R
class WorkoutAdapter(private val context: Context) : BaseAdapter()  {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var workouts: List<Workout> = emptyList()

    fun setWorkouts(workouts: List<Workout>){
        this.workouts = workouts
    }
    override fun getCount(): Int {
        return workouts.size
    }

    override fun getItem(position: Int): Any {
        return workouts[position]
    }

    override fun getItemId(position: Int): Long {
        return workouts[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        parent.parent
        val view: View = convertView ?: inflater.inflate(R.layout.workout_item, parent, false)

        val workoutNameTextView: TextView = view.findViewById(R.id.workout_item_name)
        val workout = workouts[position]

        workoutNameTextView.text = workout.name

        return view
    }
}