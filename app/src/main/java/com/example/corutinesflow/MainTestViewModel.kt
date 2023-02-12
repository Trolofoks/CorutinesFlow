package com.example.corutinesflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainTestViewModel():ViewModel() {

    private val _visibleLive = MutableLiveData<Boolean>().apply {
        value = false
    }
    val visibleLive : LiveData<Boolean> = _visibleLive

    private val _messageLive = MutableLiveData<String>().apply {
        value = "Hello world"
    }
    val messageLive : LiveData<String> = _messageLive

    fun toggleVisibility(visible: Boolean){
        _visibleLive.value = visible
    }

    fun setMessage(message: String){
        _messageLive.value = message
    }

}