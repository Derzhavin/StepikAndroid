package com.example.company.myapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
class MainActivity : AppCompatActivity() {

    val REQ_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.button)
        val e = findViewById<EditText>(R.id.editText)
        val t = findViewById<TextView>(R.id.textView)

        b.setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)

            if (status == PackageManager.PERMISSION_GRANTED) {

                val url = e.text.toString()
                var code = 404

                var thr = object : Thread() {

                    override fun run() {
                        try {
                            var connection: HttpURLConnection? = null
                            connection = URL(url).openConnection() as HttpURLConnection
                            connection.connect()
                            code = connection.responseCode
                        } catch (e: Exception) {
                            code = 404
                        }

                    }

                }
                thr.start()
                thr.join()
                if (code != 404 && code != 500) {
                    t.setText("Ok")
                }
                else {
                    t.setText("Failed")
                }
            }
            else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.INTERNET), REQ_CODE)
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val e = findViewById<EditText>(R.id.editText)
        val t = findViewById<TextView>(R.id.textView)

        when(requestCode) {
            REQ_CODE -> {
                val url = e.text.toString()
                var code = 404

                var thr = object : Thread() {

                    override fun run() {
                        try {
                            var connection: HttpURLConnection? = null
                            connection = URL(url).openConnection() as HttpURLConnection
                            connection.connect()
                            code = connection.responseCode
                        }
                        catch(e: Exception) {
                            code = 404
                        }
                    }

                }
                thr.start()
                thr.join()
                if (code != 404 && code != 500) {
                    t.setText("Ok")
                }
                else {
                    t.setText("Failed")
                }
            }
        }
    }
}
