package com.pranay.roomdatabse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

lateinit var database: ContactDatabase
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java
            ,"contactDB").build()


        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"pranay","12300"))
        }
    }
}