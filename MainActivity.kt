package com.example.mynote

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynote.data.NotesDataSource
import com.example.mynote.model.Note
import com.example.mynote.screen.NoteScreen
import com.example.mynote.screen.NoteViewModel
import com.example.mynote.ui.theme.MyNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // val noteViewModel= viewModel<NoteViewModel>()
                   val noteViewModel:NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                    }

                }
            }
        }
    }

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList=noteViewModel.noteList.collectAsState().value
    NoteScreen(notes = notesList, onRemoveNote = {noteViewModel.removeNote(it)}, onAddNote = {noteViewModel.addNote(it)})
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNoteTheme {

    }
}