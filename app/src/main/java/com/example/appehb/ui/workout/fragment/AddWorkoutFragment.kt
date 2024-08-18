package com.example.appehb.ui.workout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.appehb.MainActivity
import com.example.appehb.R
import com.example.appehb.databinding.AddWorkoutFragmentBinding
import com.example.appehb.entity.Workout
import com.example.appehb.ui.workout.WorkoutViewModel

class AddWorkoutFragment :  Fragment(R.layout.add_workout_fragment) {
    private var _binding: AddWorkoutFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var workoutViewModel: WorkoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddWorkoutFragmentBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workoutViewModel = (activity as MainActivity).workoutViewModel

        binding.buttonSaveWorkout.setOnClickListener {
            val workoutName  = binding.inputWorkoutName.text.toString().trim()

            if(workoutName.isNotEmpty()) {

                    workoutViewModel.insertWorkout(
                        Workout(
                            null,
                            workoutName
                        )
                    )

                view.findNavController().navigateUp()
            } else{
                binding.inputWorkoutName.error = "Please fill out this field"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}