package com.example.preservecounteronconfigurationchange.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.preservecounteronconfigurationchange.R
import com.example.preservecounteronconfigurationchange.viewModel.CounterViewModel

class MainActivity : ComponentActivity() {
    private lateinit var counterText: TextView
    private lateinit var counterIncrementerButton: Button
    private lateinit var counterDecrementButton: Button
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.count)
        counterIncrementerButton = findViewById(R.id.counterIncrementerButton)
        counterDecrementButton = findViewById(R.id.counterDecrementerButton)
        counterIncrementerButton.setOnClickListener(View.OnClickListener {
            viewModel.incrementCounter()
        })
        counterDecrementButton.setOnClickListener(View.OnClickListener {
            viewModel.decrementCounter()
        })
        viewModel.counter.observe(this, Observer{counter ->
            counterText.text = counter.toString()})
    }
}