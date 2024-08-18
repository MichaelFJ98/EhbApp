package com.example.appehb.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appehb.MainActivity
import com.example.appehb.R
import com.example.appehb.databinding.EditExerciseFragmentBinding
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.Workout
import com.example.appehb.ui.exercise.ExerciseViewModel

class AddExerciseFragment : Fragment(R.layout.add_exercise_fragment) {
    private var _binding: EditExerciseFragmentBinding? = null
    private val binding get() = _binding!!

    private val argument: AddExerciseFragmentArgs by navArgs()
    private lateinit var currentWorkout: Workout
    private lateinit var exerciseViewModel: ExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EditExerciseFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        currentWorkout = argument.workout

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseViewModel = (activity as MainActivity).exerciseViewModel

        binding.buttonSaveExercise.setOnClickListener {
            val exerciseName = binding.inputExerciseName.text.toString().trim()
            val exerciseSets = binding.inputNumberOfSets.text.toString().trim()

            if (exerciseName.isNotEmpty() && exerciseSets.isNotEmpty()) {
                currentWorkout.id?.let { it1 ->
                    exerciseViewModel.insertExercise(
                        Exercise(
                            null,
                            it1,
                            exerciseName,
                            exerciseSets.toInt()
                        )
                    )
                }

                view.findNavController().navigateUp()
            } else {
                binding.inputExerciseName.error = "Please fill out this field"
                binding.inputNumberOfSets.error = "Please fill out this field"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}