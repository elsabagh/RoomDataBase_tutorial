package com.example.roomdatabase_tutorial.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomdatabase_tutorial.data.Note

@Database(entities = [Note::class], version = 2)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private const val DATABASE_NAME = "MyNotDatabase"

        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }
        }

        fun getInstanceWithoutContext(): NoteDatabase {
            return instance!!
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME)
                .addMigrations(MIGRATION_1_2).build()
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE NOTE_TABLE ADD COLUMN remindTimes INTEGER NOT NULL DEFAULT 0")
            }

        }
    }
}