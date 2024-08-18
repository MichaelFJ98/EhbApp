package com.example.appehb.ui.log

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appehb.database.repository.LogRepository

class LogViewModelProviderFactory(
    val app: Application,
    private val logRepository: LogRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LogViewModel(app, logRepository) as T
    }
}