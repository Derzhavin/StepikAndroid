package com.example.company.myapplication

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import android.app.PendingIntent

import android.content.Intent

import android.R.id.message

import android.app.NotificationChannel
import android.app.TaskStackBuilder
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
