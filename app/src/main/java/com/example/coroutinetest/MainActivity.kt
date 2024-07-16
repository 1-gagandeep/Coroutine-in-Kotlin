package com.example.coroutinetest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var btnShowMessage : Button
    private lateinit var btnStartTask : Button
    private lateinit var textCount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnShowMessage = findViewById(R.id.btn_show_message)
        btnStartTask = findViewById(R.id.btn_start_task)
        textCount = findViewById(R.id.text_count)

        btnShowMessage.setOnClickListener {
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_SHORT).show()
        }

        btnStartTask.setOnClickListener {

            lifecycleScope.launch (Dispatchers.IO) {

               for(i in 1..100000) {
                   withContext(Dispatchers.Main) {
                       textCount.text = i.toString()
                   }
                }
           }
        }
    }
}