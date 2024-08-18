package com.example.appehb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appehb.entity.Workout
import com.example.appehb.databinding.WorkoutLayoutAdapterBinding
import com.example.appehb.ui.workout.fragment.WorkoutListFragmentDirections

class WorkoutAdapter : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> () {
    class WorkoutViewHolder(val itemBinding: WorkoutLayoutAdapterBinding) :
            RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback =
        object : DiffUtil.ItemCallback<Workout>() {
            override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
                return oldItem == newItem
            }
        }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        return WorkoutViewHolder(
            WorkoutLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val currentWorkout = differ.currentList[position]

        holder.itemBinding.tvWorkoutTitle.text = currentWorkout.name

        holder.itemView.setOnClickListener { view ->
            val direction = WorkoutListFragmentDirections.fabAddWorkout()
            view.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}