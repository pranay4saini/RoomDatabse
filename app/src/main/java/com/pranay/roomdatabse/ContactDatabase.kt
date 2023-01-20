package com.pranay.roomdatabse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class], version = 1 )
@TypeConverters(Convertors::class)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    /*
        ***SINGLETON PATTERN TO CREATE INSTANCE OF OUR ROOM DATABASE
     */
    companion object {
        @Volatile   //this annotation tells all threads that a value has assigned to the INSTANCE
        private var INSTANCE: ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase {

            if (INSTANCE == null) {
                synchronized(this) {  //synchronised block insures that threads dont create multiple instances of our database
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, ContactDatabase::class.java, "contactDB"
                    ).build()
                }

            }
            return INSTANCE!!
        }
    }

        //Above companion object can also be written in this form
//        companion object{
//            @Volatile
//            private var INSTANCE: ContactDatabase? = null
//            private val LOCK = Any()
//
//            operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//                instance ?: createDatabase(context).also { instance = it }
//            }
//
//            private fun createDatabase(context: Context) =
//                Room.databaseBuilder(
//                    context.applicationContext,
//                    ContactDatabase::class.java,
//                    "contactDB.db"
//
//                ).build()
//
//
//
//        }

}
