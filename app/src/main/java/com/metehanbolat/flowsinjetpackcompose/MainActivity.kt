package com.metehanbolat.flowsinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.metehanbolat.flowsinjetpackcompose.ui.theme.FlowsInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowsInJetpackComposeTheme {
                val viewModel = viewModel<MainViewModel>()
                val count = viewModel.stateFlow.collectAsState(initial = 0)
                Box(modifier = Modifier.fillMaxSize()){
                    Button(onClick = { viewModel.incrementCounter() }) {
                        Text(text = "Counter: ${count.value}")
                    }
                }
            }
        }
    }
}