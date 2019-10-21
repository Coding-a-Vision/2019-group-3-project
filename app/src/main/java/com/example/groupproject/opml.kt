package com.example.groupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class opml : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opml)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            Toast.makeText(this@opml, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button2 = findViewById(R.id.button2) as Button
        button2.setOnClickListener {
            Toast.makeText(this@opml, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        val button3 = findViewById(R.id.button3) as Button
        button3.setOnClickListener {
            Toast.makeText(this@opml, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        
    }
}
