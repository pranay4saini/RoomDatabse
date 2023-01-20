package com.pranay.roomdatabse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

lateinit var database: ContactDatabase
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)


        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"bittu","12300", Date()))
        }
    }
}