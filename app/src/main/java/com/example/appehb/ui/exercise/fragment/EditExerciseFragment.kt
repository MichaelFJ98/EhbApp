package com.example.appehb.ui.exercise.fragment

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.appehb.MainActivity
import com.example.appehb.R
import com.example.appehb.adapter.ExerciseAdapter
import com.example.appehb.databinding.EditExerciseFragmentBinding
import com.example.appehb.entity.Exercise
import com.example.appehb.ui.exercise.ExerciseViewModel

class EditExerciseFragment : Fragment(R.layout.edit_exercise_fragment) {
    private var _binding: EditExerciseFragmentBinding? = null
    private val binding get() = _binding!!

    private val argument: EditExerciseFragmentArgs by navArgs()
    private lateinit var currentExercise: Exercise
    private lateinit var exerciseViewModel: ExerciseViewModel
    private lateinit var exerciseAdapter: ExerciseAdapter

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
        currentExercise = argument.exercise

        binding.inputExerciseName.text = SpannableStringBuilder(currentExercise.name)
        binding.inputNumberOfSets.text = SpannableStringBuilder(currentExercise.sets.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseViewModel = (activity as MainActivity).exerciseViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}