package com.example.appehb.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appehb.MainActivity
import com.example.appehb.R
import com.example.appehb.databinding.EditExerciseFragmentBinding
import com.example.appehb.databinding.FragmentImgBinding
import com.example.appehb.entity.Exercise
import com.example.appehb.entity.Workout
import com.example.appehb.ui.exercise.ExerciseViewModel
import com.example.appehb.ui.exercise.fragment.AddExerciseFragmentArgs
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class imageFragment : Fragment(R.layout.fragment_img) {
    private var _binding: FragmentImgBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImgBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread {
            val url = "https://picsum.photos/200/300"
            val bitmap = downloadImage(url)

            Handler(Looper.getMainLooper()).post {
                if (bitmap != null) {
                    binding.ivPicture.setImageBitmap(bitmap)
                }
            }
        }.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun downloadImage(urlString: String): Bitmap? {
        return try {
            val url = URL(urlString)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()

            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}