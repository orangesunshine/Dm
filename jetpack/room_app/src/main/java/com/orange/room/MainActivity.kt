package com.orange.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.orange.room.database.RoomSingle
import com.orange.room.database.RoomSingle.roomDatabase
import com.orange.room.database.entity.Book
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RoomSingle.context = this
        bt_one.setOnClickListener(View.OnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                roomDatabase.bookDao().insertAll(Book("三国演义"))
            }
        })

        bt_two.setOnClickListener(View.OnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                bt_one.text = withContext(Dispatchers.IO) {
                    roomDatabase.bookDao().queryAll()
                }.toString()
            }
        })
    }
}