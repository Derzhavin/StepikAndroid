package com.example.company.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigInteger

fun f(_src: Int, s: Int): Int {
    var res = ""
    var src = _src

    while (src >= s - 1) {
        val full = src / s
        val remain = src % s

        res += remain.toString()

        src = full
    }
    return res.reversed().toInt()
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number: EditText = findViewById(R.id.number)
        val systemOfCalculus: EditText = findViewById(R.id.systemOfCalculus)
        val convertResult: TextView = findViewById(R.id.convertResult)
        val convertButton: Button = findViewById(R.id.convertButton)

        convertButton.setOnClickListener {
            val num = number.text.toString().toIntOrNull()
            val sys = systemOfCalculus.text.toString().toIntOrNull()

            if (num == null || sys == null || sys > 36) {
                convertResult.setText("Error")
            }
            else {
//                val converted = f(num, sys)
                val converted = BigInteger(num.toString()).toString(sys)
                convertResult.setText("$converted")
            }
        }
    }
}
