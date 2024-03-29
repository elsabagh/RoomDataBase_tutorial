package com.example.roomdatabase_tutorial.data.repositories

import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.data.database.NoteDatabase

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithoutContext().noteDao()

    suspend fun insertNewNote(note: Note) {
        return dao.insertNote(note)
    }

    fun getAllNotes() = dao.getAllNotes()

    suspend fun getFilteredNotes(searchTerm: String) = dao.getFilteredNotes("%$searchTerm%")
}