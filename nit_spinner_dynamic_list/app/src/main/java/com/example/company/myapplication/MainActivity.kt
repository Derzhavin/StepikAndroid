package com.example.company.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf("1")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val lim = editText.text.toString().toIntOrNull()

                if (lim == null || lim <= 0) {
                    data.clear()
                }
                else if (lim > data.size) {
                    val sz = data.size
                    for (i in sz until lim) {
                        data.add("${i + 1}")
                    }
                }
                else if (lim < data.size) {
                    val sz = data.size
                    for (i in 0 until sz - lim) {
                        data.removeAt(data.size - 1)
                    }
                }
                Log.d("Log.d", data.toString())
                adapter.notifyDataSetChanged()

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}
