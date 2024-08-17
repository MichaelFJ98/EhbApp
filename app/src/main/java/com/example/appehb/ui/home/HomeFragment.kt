package com.example.appehb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.appehb.adapter.WorkoutAdapter
import com.example.appehb.dao.WorkoutDao
import com.example.appehb.database.AppDb
import com.example.appehb.database.repository.WorkoutRepository
import com.example.appehb.databinding.FragmentHomeBinding
import com.example.appehb.entity.Workout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var workoutViewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.floatingActionButton

        button.setOnClickListener {
            workoutViewModel.upsertWorkout(Workout(5,"Test5"))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        workoutViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val root: View = binding.root

        val listView = binding.lvWorkout


        val adapter = WorkoutAdapter(requireContext())
        listView.adapter = adapter
        listOf(Workout(0,"test"))
        lifecycleScope.launch {
            workoutViewModel.workouts.collect { workouts ->
                adapter.setWorkouts(workouts)
            }
        }


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}