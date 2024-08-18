package com.example.appehb.ui.log

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appehb.database.repository.LogRepository
import com.example.appehb.entity.Log
import kotlinx.coroutines.launch

class LogViewModel(
    app: Application,
    private val logRepository: LogRepository
) : AndroidViewModel(app) {
    fun insertLog(log: Log) =
        viewModelScope.launch {
            logRepository.insertLog(log)
        }

    fun updateLog(log: Log) =
        viewModelScope.launch {
            logRepository.updateLog(log)
        }

    fun deleteLog(log: Log) =
        viewModelScope.launch {
            logRepository.deleteLog(log)
        }

    fun getLogsById(id: Int) =
        logRepository.getLogsById(id)

    fun getSetsByLogId(id: Int) =
        logRepository.getSetsByLogId(id)
}