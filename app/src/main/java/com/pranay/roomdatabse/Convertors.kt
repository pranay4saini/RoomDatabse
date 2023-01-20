package com.pranay.roomdatabse

import androidx.room.TypeConverter
import java.util.Date

class Convertors {
    @TypeConverter
    fun DateToLong(value: Date) : Long{
        return value.time
    }
    @TypeConverter
    fun LongToDate(value:Long) : Date{
        return Date(value)
    }
}
