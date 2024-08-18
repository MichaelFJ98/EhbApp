package com.example.appehb.ui.workout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appehb.MainActivity
import com.example.appehb.R
import com.example.appehb.adapter.WorkoutAdapter
import com.example.appehb.databinding.WorkoutListFragmentBinding
import com.example.appehb.entity.Workout
import com.example.appehb.ui.workout.WorkoutViewModel

class WorkoutListFragment : Fragment(R.layout.workout_list_fragment) {
    private var _binding: WorkoutListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var workoutViewModel: WorkoutViewModel
    private lateinit var workoutAdapter: WorkoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WorkoutListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workoutViewModel = (activity as MainActivity).workoutViewModel
        setUpRecyclerView()

        binding.fabAddWorkout.setOnClickListener {
            val action = WorkoutListFragmentDirections.fabAddWorkout()
            findNavController().navigate(action)
        }

        binding.toImageFrag.setOnClickListener {
            val action = WorkoutListFragmentDirections.toImageFrag()
            findNavController().navigate(action)
        }
    }

    private fun setUpRecyclerView(){
        workoutAdapter = WorkoutAdapter()

        binding.recyclerViewLvWorkout.apply {
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
            binding.noWorkoutsText.visibility = View.GONE
            binding.recyclerViewLvWorkout.visibility = View.VISIBLE
        } else {
            binding.noWorkoutsText.visibility = View.VISIBLE
            binding.recyclerViewLvWorkout.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}