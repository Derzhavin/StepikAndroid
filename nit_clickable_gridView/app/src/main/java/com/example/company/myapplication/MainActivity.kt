package com.example.company.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = (0..30).toMutableList().map { it.toString() }.toMutableList()
        val adapter: ArrayAdapter<String> = object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                view.layoutParams.height = 20
                return view
            }
        }
        gridView.adapter = adapter
        gridView.numColumns = 4

        gridView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val row = (1 + position / gridView.numColumns)
            val col = (1 + position % gridView.numColumns)

            data[position] = "$row,$col"
            adapter.notifyDataSetChanged()
        }
    }
}
