package com.example.roomdatabase_tutorial.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabase_tutorial.data.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM NOTE_TABLE")
    fun getAllNotes(): List<Note>
}