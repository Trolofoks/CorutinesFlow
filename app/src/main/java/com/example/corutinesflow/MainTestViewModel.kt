package com.example.corutinesflow

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainTestViewModel():ViewModel() {

    init {
        Log.d("MyLog","пересоздался")
    }

    private val _visibleFlow = MutableStateFlow<Boolean>(value = false)
    val visibleFlow : StateFlow<Boolean> = _visibleFlow.asStateFlow()

    private val _messageFlow = MutableStateFlow<String>(value = "Hello world")
    val messageFlow : StateFlow<String> = _messageFlow.asStateFlow()

    fun toggleVisibility(visible: Boolean){
        _visibleFlow.value = visible
    }

    fun setMessage(message: String){
        _messageFlow.value = message
    }

}