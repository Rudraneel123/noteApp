package com.example.mynote.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mynote.model.Note

class NotesDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "Android Compose", description = "Working on Compose"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer"),
            Note(title = "A great Day", description = "I got a job as an Android Developer")
        )
    }
}