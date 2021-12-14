package com.example.commonintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener(){
            val address = "address"
            val subject = "Subject"
            this.composeEmail(address,subject)
        }
        val button1 = findViewById<Button>(R.id.btn2)
        button1.setOnClickListener(){
            showMap()
        }
        val button3 = findViewById<Button>(R.id.btn3)
        button3.setOnClickListener(){
            //openWifiSettings()
        }
        val button4 = findViewById<Button>(R.id.btn4)
        button4.setOnClickListener(){
            quitApp()
        }
    }
    fun composeEmail(addresses: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        startActivity(intent)

    }
    fun showMap() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.google.com/maps")
        }

            startActivity(intent)
    }

    fun quitApp() {
        this@MainActivity.finish()
        exitProcess(0)
    }

}