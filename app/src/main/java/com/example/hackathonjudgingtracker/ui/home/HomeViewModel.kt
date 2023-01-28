package com.example.hackathonjudgingtracker.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _numProjects = MutableStateFlow("")
    val numProjects: StateFlow<String> = _numProjects

    private val _numJudges = MutableStateFlow("")
    val numJudges: StateFlow<String> = _numJudges

    fun updateNumProjects(numProjects: String) {
        _numProjects.value = numProjects
    }

    fun updateNumJudges(numJudges: String) {
        _numJudges.value = numJudges
    }
}