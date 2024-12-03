package com.example.preservecounteronconfigurationchange.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Ratna Srivastava on 03-12-2024.
 */
class CounterViewModel: ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = _counter

    init {
        _counter.value = 0
    }

    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrementCounter() {
       val currentCount: Int = _counter.value ?: 0
        if(currentCount > 0)
            _counter.value = currentCount - 1
    }
}