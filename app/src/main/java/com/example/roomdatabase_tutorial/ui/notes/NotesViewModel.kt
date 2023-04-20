package com.example.roomdatabase_tutorial.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.repositories.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.util.Date

class NotesViewModel : ViewModel() {

    private val repository = NoteRepository()

    val newNoteText = MutableLiveData<String>()

    val searchText = MutableStateFlow("")

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes
//    val notes: LiveData<List<Note>> = repository.getAllNotes().asLiveData()

    init {
        loadData()

        searchData()
    }

    fun addNote() {
        viewModelScope.launch {
            newNoteText.value?.let {
                repository.insertNewNote(Note(0, it, Date(), false))
                newNoteText.postValue("")

            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getAllNotes().collect {
                _notes.postValue(it)
            }

        }
    }

    private fun searchData() {
        viewModelScope.launch {
            searchText.debounce(500).collect {
                val result = repository.getFilteredNotes(it)
                _notes.postValue(result)
            }
        }
    }

}