package com.example.hackathonjudgingtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.hackathonjudgingtracker.ui.home.HomeScreen
import com.example.hackathonjudgingtracker.ui.home.HomeViewModel
import com.example.hackathonjudgingtracker.ui.theme.HackathonJudgingTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HackathonJudgingTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val homeViewModel = HomeViewModel()
                    HomeScreen(homeViewModel)
                }
            }
        }
    }
}