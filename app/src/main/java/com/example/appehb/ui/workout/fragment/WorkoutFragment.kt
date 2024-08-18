package com.example.appehb.ui.workout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appehb.MainActivity
import com.example.appehb.R

import com.example.appehb.adapter.WorkoutAdapter
import com.example.appehb.databinding.WorkoutItemFragmentBinding
import com.example.appehb.entity.Workout
import com.example.appehb.ui.workout.WorkoutViewModel

class WorkoutFragment : Fragment(R.layout.workout_item_fragment){
    private var _binding: WorkoutItemFragmentBinding? = null
    private val binding get() = _binding!!

    private val argument: WorkoutFragmentArgs by navArgs()
    private lateinit var currentWorkout: Workout
    private lateinit var workoutViewModel: WorkoutViewModel
    private lateinit var workoutAdapter: WorkoutAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WorkoutItemFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        currentWorkout = argument.workout

        binding.workoutItemName.text = currentWorkout.name

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workoutViewModel = (activity as MainActivity).workoutViewModel
        //setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        workoutAdapter = WorkoutAdapter()

        binding.recyclerViewExercises.apply {
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = workoutAdapter
        }

        activity?.let {
            workoutViewModel.getWorkouts().observe(viewLifecycleOwner) { workout ->
                workoutAdapter.differ.submitList(workout)
                updateUI(workout)
            }
        }
    }

    private fun updateUI(workouts: List<Workout>) {
        if(workouts.isNotEmpty()) {
            binding.noExercisesText.visibility = View.GONE
            binding.recyclerViewExercises.visibility = View.VISIBLE
        } else {
            binding.noExercisesText.visibility = View.VISIBLE
            binding.recyclerViewExercises.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}