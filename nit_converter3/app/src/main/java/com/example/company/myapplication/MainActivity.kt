package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (currentFocus == editText) {
                    val i = s.toString().toFloatOrNull()

                    if (i == null) {
                        status.setText("error")
                    } else {
                        val i1 = i / 39370f
                        editText2.setText(i1.toString())
                        status.setText("")
                    }
                }
            }
        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (currentFocus == editText2) {
                    val i = s.toString().toFloatOrNull()

                    if (i == null) {
                        status.setText("error")
                    }
                    else {
                        val i1 = i * 39370f
                        editText.setText(i1.toString())
                        status.setText("")
                    }
                }
            }
        })
    }
}
