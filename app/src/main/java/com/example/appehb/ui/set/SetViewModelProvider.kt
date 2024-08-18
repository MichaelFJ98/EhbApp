package com.example.appehb.ui.set

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appehb.database.repository.SetRepository

class SetViewModelProvider (
    val app: Application,
    private val setRepository: SetRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SetViewModel(app, setRepository) as T
    }
}