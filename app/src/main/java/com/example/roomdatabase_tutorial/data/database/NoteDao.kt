package com.example.roomdatabase_tutorial.data.database

import android.widget.RemoteViews.RemoteCollectionItems
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabase_tutorial.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC")
     fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM NOTE_TABLE WHERE content LIKE :searchTerm ORDER BY id DESC")
    suspend fun getFilteredNotes(searchTerm: String): List<Note>
}