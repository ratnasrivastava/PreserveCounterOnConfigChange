package com.example.preservecounteronconfigurationchange.viewModel

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

    fun updateCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }
}