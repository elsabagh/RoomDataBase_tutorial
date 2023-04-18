package com.example.roomdatabase_tutorial.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.repositories.NoteRepository
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesViewModel : ViewModel() {

    private val repository = NoteRepository()

    val newNoteText = MutableLiveData<String>()

    //    private val _notes = MutableLiveData<List<Note>>()
//    val notes: LiveData<List<Note>> = _notes
    val notes: LiveData<List<Note>> = repository.getAllNotes()

    //    init {
//        loadData()
//    }
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
//    fun loadData(){
//        repository.getAllNotes()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                this::onGetNotes,
//                this::onNotesFail
//            )
//    }
//
//    private fun onGetNotes(listOfNotes: List<Note>){
//        _notes.postValue(listOfNotes)
//    }
//
//    private fun onNotesFail(t: Throwable){
//
//    }
}