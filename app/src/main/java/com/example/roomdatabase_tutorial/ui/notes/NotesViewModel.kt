package com.example.roomdatabase_tutorial.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.repositories.NoteRepository
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    private val repository = NoteRepository()

    val newNoteText = MutableLiveData<String>()

//    private val _notes = MutableLiveData<List<Note>>()
//    val notes: LiveData<List<Note>> = _notes
    val notes: LiveData<List<Note>> = repository.getAllNotes().asLiveData()

//        init {
//        loadData()
//    }

    fun addNote() {
        viewModelScope.launch {
            newNoteText.value?.let {
                repository.insertNewNote(Note(0, it, "16/4/2022", false))
                newNoteText.postValue("")

            }
        }
    }
//    private fun loadData(){
//        viewModelScope.launch {
//            repository.getAllNotes().collect{
//                _notes.postValue(it)
//            }
//
//        }
//    }
}