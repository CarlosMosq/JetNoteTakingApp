package com.company.notetakingapp.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromDate(date: Date) : Long {
        return date.time
    }

    @TypeConverter
    fun dateTimeStamp(timeStamp: Long) : Date? {
        return Date(timeStamp)
    }
}