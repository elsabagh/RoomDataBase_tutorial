package com.example.roomdatabase_tutorial.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.repositories.NoteRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesViewModel : ViewModel() {

    val newNoteText = MutableLiveData<String>()

    private val repository = NoteRepository()

    fun addNote() {
        newNoteText.value?.let {
            repository.insertNewNote(
                Note(0, it, "16/4/2022", false)
            )
                .subscribeOn(Schedulers.io())
                .subscribe()
            newNoteText.postValue("")
        }
    }
}