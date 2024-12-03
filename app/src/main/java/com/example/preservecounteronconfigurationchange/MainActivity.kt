package com.example.preservecounteronconfigurationchange

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.preservecounteronconfigurationchange.ui.theme.PreserveCounterOnConfigurationChangeTheme

class MainActivity : ComponentActivity() {
    private lateinit var counterText: TextView
    private lateinit var counterIncrementerButton: Button
    private var counter = 0

    companion object{
        private const val COUNTER_KEY = "counter"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.count)
        counterIncrementerButton = findViewById(R.id.counterButton)
        counterIncrementerButton.setOnClickListener(View.OnClickListener {
            counter++
            updateCounterTextView()
        })

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER_KEY, 0)
            updateCounterTextView()
        }
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getInt(COUNTER_KEY, 0)
        updateCounterTextView()
    }

    private fun updateCounterTextView() {
        counterText.text = counter.toString()
    }
}