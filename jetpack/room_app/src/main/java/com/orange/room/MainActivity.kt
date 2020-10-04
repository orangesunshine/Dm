package com.orange.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orange.room.database.RoomSingle.roomDatabase
import com.orange.room.database.entity.Book

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomDatabase.bookDao().insertAll(Book("三国演义"))
    }
}