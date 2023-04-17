package com.example.roomdatabase_tutorial.data.repositories

import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.database.NoteDatabase

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithoutContext().noteDao()

    fun insertNewNote(note: Note){
        dao.insertNote(note)
    }
}