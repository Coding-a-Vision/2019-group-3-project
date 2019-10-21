package com.example.groupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection

        return when (item.itemId) {
            R.id.button_add -> {
                val intent = Intent(this, add_page::class.java)
                startActivity(intent)
                true
            }

            R.id.button_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.button_settings -> {
                val intent = Intent(this, settings::class.java)
                startActivity(intent)
                true
            }

            R.id.button_opml -> {
                val intent = Intent(this, opml::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}
