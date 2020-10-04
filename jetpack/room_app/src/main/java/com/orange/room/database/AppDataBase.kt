package com.orange.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orange.room.database.dao.BookDao
import com.orange.room.database.entity.Book

@Database(entities = [Book::class],version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun bookDao():BookDao
}