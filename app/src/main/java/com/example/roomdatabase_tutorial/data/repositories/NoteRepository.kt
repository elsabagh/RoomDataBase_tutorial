package com.example.roomdatabase_tutorial.data.repositories

import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.database.NoteDatabase
import io.reactivex.rxjava3.core.Completable

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithoutContext().noteDao()

    fun insertNewNote(note: Note): Completable{
        return dao.insertNote(note)
    }

    fun getAllNotes() = dao.getAllNotes()
}