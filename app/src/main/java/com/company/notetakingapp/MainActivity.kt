package com.company.notetakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.company.notetakingapp.screen.NoteScreen
import com.company.notetakingapp.screen.NoteViewModel
import com.company.notetakingapp.ui.theme.NoteTakingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value
    NoteScreen(
        notes = notesList,
        onAddNote = {noteViewModel.addNote(it)},
        onRemoveNote = {noteViewModel.removeNote(it)}
    )
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteTakingAppTheme {

    }
}