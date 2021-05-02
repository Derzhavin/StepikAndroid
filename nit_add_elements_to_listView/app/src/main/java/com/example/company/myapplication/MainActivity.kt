package com.example.company.myapplication


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf("0", "1", "4", "9", "16", "25", "36", "49", "64", "81", "100")

        val adapter: ArrayAdapter<String> = object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                view.layoutParams.height = 20
                return view
            }
        }

        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        listView.setOnItemClickListener { parent, view, pos, id ->
            data.add(data[listView.checkedItemPosition])
            adapter.notifyDataSetChanged()
        }
    }
}
