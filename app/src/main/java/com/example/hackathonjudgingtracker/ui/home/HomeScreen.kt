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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val numProjects = homeViewModel.numProjects.collectAsState()
    val numJudges = homeViewModel.numJudges.collectAsState()
    HomeContent(
        numProjects = numProjects.value,
        onNumProjectsChanged = { homeViewModel.updateNumProjects(it) },
        numJudges = numJudges.value,
        onNumJudgesChanged = { homeViewModel.updateNumJudges(it) }
    )
}

@Composable
fun HomeContent(
    numProjects: String,
    onNumProjectsChanged: (String) -> Unit,
    numJudges: String,
    onNumJudgesChanged: (String) -> Unit
) {
    Surface() {
        Column {
            var numPassThroughs by remember { mutableStateOf("") }
            var lengthEvent by remember { mutableStateOf("") }
            var numProjectsPerJudge by remember { mutableStateOf(0) }
            var timePerProject by remember { mutableStateOf(0) }

            Row {
                Text(text = "Number of Projects: ")
                BasicTextField(value = numProjects, onValueChange = onNumProjectsChanged)
            }
            Row {
                Text(text = "Number of Judges: ")
                BasicTextField(value = numJudges, onValueChange = { onNumJudgesChanged })
            }
            Row {
                Text(text = "How Many Times Should Each Project Be Seen? ")
                BasicTextField(value = numPassThroughs, onValueChange = { numPassThroughs = it })
            }
            Row {
                Text(text = "How Long Is Judging?(Minutes) ")
                BasicTextField(value = lengthEvent, onValueChange = { lengthEvent = it })
            }
            Button(onClick = {
                numProjectsPerJudge =
                    (numProjects.toInt() * numPassThroughs.toInt()) / numJudges.toInt()
                timePerProject = lengthEvent.toInt() / numProjectsPerJudge
            }) {
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
        numProjects = "10",
        onNumProjectsChanged = {},
        numJudges = "2",
        onNumJudgesChanged = {}
    )
}