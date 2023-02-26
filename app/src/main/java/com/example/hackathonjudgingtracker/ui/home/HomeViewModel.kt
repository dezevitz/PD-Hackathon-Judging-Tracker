package com.example.hackathonjudgingtracker.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _numProjects = MutableStateFlow("")
    val numProjects: StateFlow<String> = _numProjects

    private val _numJudges = MutableStateFlow("")
    val numJudges: StateFlow<String> = _numJudges

    private val _numPassThroughs = MutableStateFlow("")
    val numPassThroughs: StateFlow<String> = _numPassThroughs

    private val _lengthEvent = MutableStateFlow("")
    val lengthEvent: StateFlow<String> = _lengthEvent

    private val _numProjectsPerJudge = MutableStateFlow(0)
    val numProjectsPerJudge: StateFlow<Int> = _numProjectsPerJudge

    private val _timePerProject = MutableStateFlow(0)
    val timePerProject: StateFlow<Int> = _timePerProject

    fun updateNumProjects(numProjects: String) {
        _numProjects.value = numProjects
    }

    fun updateNumJudges(numJudges: String) {
        _numJudges.value = numJudges
    }

    fun updateNumPassThroughs(numPassThroughs: String) {
        _numPassThroughs.value = numPassThroughs
    }

    fun updateLengthEvent(lengthEvent: String) {
        _lengthEvent.value = lengthEvent
    }

    fun calculateValues() {
        _numProjectsPerJudge.value =
            (numProjects.value.toInt() * numPassThroughs.value.toInt()) / numJudges.value.toInt()
        _timePerProject.value = lengthEvent.value.toInt() / numProjectsPerJudge.value
    }

}