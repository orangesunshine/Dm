package com.orange.room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.orange.room.database.entity.Book

@Dao
interface BookDao {
    @Query("select count(*) from book")
    suspend fun queryAll(): Int

    @Insert
    suspend fun insertAll(vararg books: Book)
}