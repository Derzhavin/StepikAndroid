package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var text: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write your code here
        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val editTextViewStr = editText.text.toString()
                val cnt = Regex(pattern = """[A-Za-z0-9_А-Яа-я]+""").findAll(input = editTextViewStr).count()
                stats_view.setText("$cnt")
                if (editTextViewStr != text) {
                    unsaved_changes_view.setText("Unsaved changes")
                }
                else {
                    unsaved_changes_view.setText("All changes saved")
                }
            }
        })
        save_button.setOnClickListener {
            text = editText.text.toString()
            unsaved_changes_view.setText("All changes saved")
        }
        clear_button.setOnClickListener {
            editText.setText("")
            unsaved_changes_view.setText("Unsaved changes")
        }
        load_button.setOnClickListener {
            editText.setText(text)
            unsaved_changes_view.setText("All changes saved")
        }
    }
}
