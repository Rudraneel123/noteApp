package com.example.mynote.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.data.NotesDataSource
import com.example.mynote.model.Note
import com.example.mynote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) :ViewModel(){

    private val _notelist=MutableStateFlow<List<Note>>(emptyList())
    //var noteList= mutableStateListOf<Note>()
    val noteList=_notelist.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect(){
                    listOfNotes->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("Empty" ,"Empty List")
                    }
                    else{
                        _notelist.value =listOfNotes
                    }
                }

        }
        //noteList.addAll(NotesDataSource().loadNotes())
    }
     fun addNote(note:Note)=viewModelScope.launch { repository.addNote(note) }
     fun updateNote(note:Note)=viewModelScope.launch { repository.updateNote(note)}
     fun removeNote(note:Note)=viewModelScope.launch { repository.deleteNote(note) }



}