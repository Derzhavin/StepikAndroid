package com.example.company.myapplication

import android.R.layout.simple_spinner_item
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
//
fun isWin(s: List<List<Spinner>>, target: String): Boolean {
    fun v(sp: Spinner): Boolean {
        return sp.selectedItem.toString() == target
    }

    return (
            (v(s[0][0]) && v(s[0][1]) && v(s[0][2]))
            ||
            (v(s[1][0]) && v(s[1][1]) && v(s[1][2]))
            ||
            (v(s[2][0]) && v(s[2][1]) && v(s[2][2]))
            ||
            (v(s[0][0]) && v(s[1][0]) && v(s[1][2]))
            ||
            (v(s[1][0]) && v(s[1][1]) && v(s[1][2]))
            ||
            (v(s[2][0]) && v(s[2][1]) && v(s[2][2]))
            ||
            (v(s[0][0]) && v(s[1][1]) && v(s[2][2]))
            ||
            (v(s[0][2]) && v(s[1][1]) && v(s[2][0]))
            )
}
class MainActivity : AppCompatActivity() {

    var list_of_items = arrayOf("","X", "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write your code here
        val s11: Spinner = findViewById(R.id.spinner11)
        val s12: Spinner = findViewById(R.id.spinner12)
        val s13: Spinner = findViewById(R.id.spinner13)
        val s21: Spinner = findViewById(R.id.spinner21)
        val s22: Spinner = findViewById(R.id.spinner22)
        val s23: Spinner = findViewById(R.id.spinner23)
        val s31: Spinner = findViewById(R.id.spinner31)
        val s32: Spinner = findViewById(R.id.spinner32)
        val s33: Spinner = findViewById(R.id.spinner33)

        val status: TextView = findViewById(R.id.status)

        val spinners = listOf(listOf(s11, s12, s13), listOf(s21, s22, s23), listOf(s31, s32, s33))
        val spinnersFlatten = spinners.flatten()

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val arrayAdapter = ArrayAdapter(this, simple_spinner_item, list_of_items)
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinners[i][j].setAdapter(arrayAdapter)
                spinners[i][j].setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                        Log.d("LOG", "event")
                        val Xcnt = spinnersFlatten.count { it.selectedItem.toString() ==  "X"}
                        val Ocnt = spinnersFlatten.count { it.selectedItem.toString() ==  "0"}
                        Log.d("LOG", "event, Xcnt: $Xcnt, Ocnt: $Ocnt")

                        if (Xcnt - Ocnt > 1) {
                            status.setText("Invalid")
                        }
                        else if (isWin(spinners, "X")) {
                            status.setText("X won")
                            Log.d("LOG", "X won")
                        }
                        else if (isWin(spinners, "0")) {
                            status.setText("0 won")
                            Log.d("LOG", "0 won")
                        }
                        else if (Xcnt + Ocnt == 9){
                            status.setText("Draw")
                            Log.d("LOG", "Draw")
                        }
                        else {
                            status.setText("")
                            Log.d("LOG", "nop")
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                })
            }
        }
    }
}
