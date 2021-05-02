package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        perform.setOnClickListener {
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                val path =
                    Environment.getExternalStorageDirectory().path + "/" + filepath.text.toString()
                FileInputStream(path).use { stream ->
                    val text = stream.bufferedReader().use {
                        it.readText()
                    }
                    result.setText(text)
                }
            }
        }
    }
}
