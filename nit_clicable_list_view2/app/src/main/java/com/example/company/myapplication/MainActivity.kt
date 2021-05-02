package com.example.company.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf("1", "2", "3")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, data)
        listView1.adapter = adapter
        listView1.choiceMode = ListView.CHOICE_MODE_SINGLE

        listView1.setOnItemClickListener { parent, view, pos, id ->
            val i = Intent(this, ListItemActivity::class.java)
            i.putExtra("num", data[pos])
            startActivity(i)
        }
    }
}
