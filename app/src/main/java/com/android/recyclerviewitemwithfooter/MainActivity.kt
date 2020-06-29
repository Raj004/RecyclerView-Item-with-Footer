package com.android.recyclerviewitemwithfooter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiwari.rajshekhar.headerrecyclerview.HeaderAdapter


import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    val listItems: ArrayList<Generic>
        get() {
            val generics = ArrayList<Generic>()
            for (i in 0..9) {
                val item = Generic()
                item.name = "list item$i"
                generics.add(item)
            }
            return generics
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.my_recycler_view) as RecyclerView?
        val linearLayoutManager = LinearLayoutManager(this)
        val adapter = HeaderAdapter(this@MainActivity, listItems)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }


}