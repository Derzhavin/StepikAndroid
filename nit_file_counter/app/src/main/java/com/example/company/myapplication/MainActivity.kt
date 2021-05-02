package com.example.company.myapplication

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.perform).setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

            if (status == PackageManager.PERMISSION_GRANTED) {
                try {
                    val path = findViewById<EditText>(R.id.path).text.toString()
                    findViewById<TextView>(R.id.result).setText(
                        File(path).listFiles().filter { it.isFile }.size.toString()
                    )
                } catch (e: Exception) {
                    findViewById<TextView>(R.id.result).setText("Error")
                    Log.d("LOG", e.toString())
                }
            }
        }
    }
}
