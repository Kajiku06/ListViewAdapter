package com.example32.listviewadapter

import CustomAdapter
import ItemA
import ItemB
import ItemC
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = ArrayList<Any>()
        dataList.add(ItemA("Item A"))
        dataList.add(ItemB("Item B"))
        dataList.add(ItemC("Item C"))

        adapter = CustomAdapter(dataList)
        recyclerView.adapter = adapter
    }
}