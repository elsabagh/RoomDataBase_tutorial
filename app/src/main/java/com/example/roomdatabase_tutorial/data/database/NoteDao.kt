package com.example.roomdatabase_tutorial.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabase_tutorial.data.Note
import io.reactivex.rxjava3.core.Completable

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Update
    fun update(note: Note): Completable

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>
}