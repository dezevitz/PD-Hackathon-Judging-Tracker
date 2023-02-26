package com.example.hackathonjudgingtracker.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val numProjects = homeViewModel.numProjects.collectAsState()
    val numJudges = homeViewModel.numJudges.collectAsState()
    val numPassThroughs = homeViewModel.numPassThroughs.collectAsState()
    val lengthEvent = homeViewModel.lengthEvent.collectAsState()
    val numProjectsPerJudge = homeViewModel.numProjectsPerJudge.collectAsState()
    val timePerProject = homeViewModel.timePerProject.collectAsState()
    HomeContent(
        numProjects = numProjects.value,
        onNumProjectsChanged = { homeViewModel.updateNumProjects(it) },
        numJudges = numJudges.value,
        onNumJudgesChanged = { homeViewModel.updateNumJudges(it) },
        numPassThroughs = numPassThroughs.value,
        onNumPassThroughsChanged = { homeViewModel.updateNumPassThroughs(it) },
        lengthEvent = lengthEvent.value,
        onLengthEventChanged = { homeViewModel.updateLengthEvent(it) },
        calculateValues = { homeViewModel.calculateValues() },
        numProjectsPerJudge = numProjectsPerJudge.value.toString(),
        timePerProject = timePerProject.value.toString()
    )
}

@Composable
fun HomeContent(
    numProjects: String,
    onNumProjectsChanged: (String) -> Unit,
    numJudges: String,
    onNumJudgesChanged: (String) -> Unit,
    numPassThroughs: String,
    onNumPassThroughsChanged: (String) -> Unit,
    lengthEvent: String,
    onLengthEventChanged: (String) -> Unit,
    calculateValues: () -> Unit,
    numProjectsPerJudge: String,
    timePerProject: String
) {
    Surface {
        Column {
            Row {
                Text(text = "Number of Projects: ")
                BasicTextField(value = numProjects, onValueChange = onNumProjectsChanged)
            }
            Row {
                Text(text = "Number of Judges: ")
                BasicTextField(value = numJudges, onValueChange = onNumJudgesChanged)
            }
            Row {
                Text(text = "How Many Times Should Each Project Be Seen? ")
                BasicTextField(value = numPassThroughs, onValueChange = onNumPassThroughsChanged)
            }
            Row {
                Text(text = "How Long Is Judging?(Minutes) ")
                BasicTextField(value = lengthEvent, onValueChange = onLengthEventChanged)
            }
            Button(onClick = { calculateValues() }) {
                Text(text = "Calculate")
            }
            Text(text = "Number of Projects Per Judge: $numProjectsPerJudge")
            Text(text = "Time each judge should spend on each table (in Minutes): $timePerProject")
        }
    }
}

@Preview
@Preview(name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeContentPreview() {
    HomeContent(
        numProjects = "100",
        onNumProjectsChanged = {},
        numJudges = "10",
        onNumJudgesChanged = {},
        numPassThroughs = "2",
        onNumPassThroughsChanged = {},
        lengthEvent = "180",
        onLengthEventChanged = {},
        calculateValues = {},
        numProjectsPerJudge = "20",
        timePerProject = "9"
    )
}