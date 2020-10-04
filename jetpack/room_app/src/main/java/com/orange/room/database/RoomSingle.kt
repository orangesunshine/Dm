package com.orange.room.database

import android.content.Context
import androidx.room.Room

object RoomSingle {
    lateinit var context: Context

    val roomDatabase by lazy {
        Room.databaseBuilder(context, AppDataBase::class.java, "logging.db").build()
    }
}