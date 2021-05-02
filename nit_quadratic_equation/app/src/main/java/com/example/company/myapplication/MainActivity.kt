package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

fun findRoots(a: Float, b: Float, c: Float): Triple<Float?, Float?, String> {
    var stat = "Any number"

    var x1: Float? = null
    var x2: Float? = null
    val D = b * b -4 * a * c

    if (a == 0f && b == 0f && c == 0f) {
        stat = "Any number"
    }
    else if (D < 0f || (a == 0f && b == 0f && c != 0f)) {
        stat = "No real roots"
    }
    else if (a == 0f && b!= 0f) {
        x1 = -c / b
        x2 = null
        stat = "One root"
    }
    else if (D == 0f) {
        x1 = -b / 2 / a
        x2 = x1
        stat = "One root"
    }
    else {
        x1 = (-b + sqrt(D)) / 2 / a
        x2 = (-b - sqrt(D)) / 2 / a
        stat = "Two roots"
    }

    return Triple(x1, x2, stat)
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aVal:EditText = findViewById(R.id.aValue)
        val bVal:EditText = findViewById(R.id.bValue)
        val cVal:EditText = findViewById(R.id.cValue)
        val x1Val:EditText = findViewById(R.id.x1Value)
        val x2Val:EditText = findViewById(R.id.x2Value)
        val isSolutionExist:TextView = findViewById(R.id.isSolutionExist)

        val edits = listOf(aVal, bVal, cVal, x1Val, x2Val)

        edits.forEach { e ->
            e.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {

                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (currentFocus == e) {
                        val a = aVal.text.toString().toFloatOrNull()
                        val b = bVal.text.toString().toFloatOrNull()
                        val c = cVal.text.toString().toFloatOrNull()
                        val x1 = x1Val.text.toString().toFloatOrNull()
                        val x2 = x2Val.text.toString().toFloatOrNull()

                        if (a == null || b == null || c == null || x1 == null || x2 == null) {
                            isSolutionExist.setText("error")
                        }
                        else if (e == aVal || e == bVal || e == cVal){
                            val p = findRoots(a, b, c)
                            val x1r = p.first
                            val x2r = p.second
                            val stat = p.third

                            isSolutionExist.setText(stat)

                            if (stat == "Any number") {

                            }
                            x1Val.setText("$x1r")
                            x2Val.setText(if (x2r == null) "" else "$x2r")
                        }
                        else if (e == x1Val || e == x2Val) {
                            val a1 = 1
                            val b1 = b
                            val c1 = x1 * x1 - b1 * x1
                            aVal.setText("$a1")
                            bVal.setText("$b1")
                            cVal.setText("$c1")
                        }
                    }
                }
            })
        }
    }
}
