package com.orange.room.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class Book(var name:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}