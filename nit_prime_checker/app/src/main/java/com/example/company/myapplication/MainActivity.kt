package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

fun isPrime(x: Int): Boolean {
    var k = 2
    while (k * k <= x && x % k != 0) k ++
    return x > 1 && k * k > x
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write your code here
        checkBtn.setOnClickListener {
            val i = editText.text.toString().toIntOrNull()

            if (i == null) {
                textView.setText("error")
            }
            else if (isPrime(i)){
                textView.setText("prime")
            }
            else {
                textView.setText("not prime")
            }
        }
    }
}
