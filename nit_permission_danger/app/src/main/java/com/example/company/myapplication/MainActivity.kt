package com.example.company.myapplication

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var REQ_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val v = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.button).setOnClickListener {
            val status = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

            if (status == PackageManager.PERMISSION_GRANTED) {
                v.setText("Granted")
            }
            else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), REQ_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val v = findViewById<TextView>(R.id.textView)

        when(requestCode) {
            REQ_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Разрешение выдано, можно использовать "опасный" функционал
                    v.setText("Granted")

                } else {
                    // Разрешение не выдано, необходимо использовать другой способ
                    v.setText("Denied")
                }
                return
            }
            else -> {
                // id запроса не совпадает с ожидаемым, игнорируем
            }
        }
    }
}
