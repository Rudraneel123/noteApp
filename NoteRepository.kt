package com.example.mynote.repository

import com.example.mynote.data.NoteDatabase
import com.example.mynote.data.NoteDatabaseDao
import com.example.mynote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note)=noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note)=noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note)=noteDatabaseDao.deleteNode(note)
    suspend fun deleteAllNotes()=noteDatabaseDao.deleteAll()
      fun getAllNotes(): kotlinx.coroutines.flow.Flow<List<Note>> =noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()

}