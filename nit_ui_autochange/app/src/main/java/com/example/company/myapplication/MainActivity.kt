package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var cnt : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write your code here
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var text = s.toString()
                if (text.contains("question")) {
                    text = text.replace("question","answer")
                    editText.post{editText.setText(text)}// вставить содердимое text в editText
                    cnt++
                }

                else if (text.contains("request")) {
                    text = text.replace("request", "response")
                    editText.post{editText.setText(text)}// вставить содердимое text в editText
                    cnt++
                }

                else if (text.contains("problem")) {
                    text = text.replace("problem", "task")
                    editText.post{editText.setText(text)}// вставить содердимое text в editText
                    cnt++
                }
                editText.setSelection(editText.length()) // перевод корретки на конец
                textView.setText("$cnt").toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
    }
}
