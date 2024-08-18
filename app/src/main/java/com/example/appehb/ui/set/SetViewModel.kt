package com.example.appehb.ui.set

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appehb.database.repository.SetRepository
import kotlinx.coroutines.launch

class SetViewModel(
    app: Application,
    private val setRepository: SetRepository
) : AndroidViewModel(app) {
    fun insertSet(set: com.example.appehb.entity.Set) =
        viewModelScope.launch {
            setRepository.insertSet(set)
        }

    fun updateSet(set: com.example.appehb.entity.Set) =
        viewModelScope.launch {
            setRepository.updateSet(set)
        }

    fun deleteSet(set: com.example.appehb.entity.Set) =
        viewModelScope.launch {
            setRepository.deleteSet(set)
        }

    fun getSetById(id: Int) =
        setRepository.getSetById(id)
}