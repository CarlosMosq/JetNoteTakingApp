package com.company.notetakingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.company.notetakingapp.model.Note
import com.company.notetakingapp.util.DateConverter
import com.company.notetakingapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() :  NoteDatabaseDao
}