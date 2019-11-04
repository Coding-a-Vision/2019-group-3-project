package com.reader.groupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import android.widget.TextView


class add_page : AppCompatActivity() {
    var link: String = ""
    val search = search_class()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_page)

        Thread(Runnable {
            search_fun()
        }).start()

        val searchView = findViewById<SearchView>(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String): Boolean {
                set_link(s)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                set_link(s)
                return true
            }
        })
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

    fun set_link(new_link: String){
        this.link = new_link
    }

    fun search_fun() {
        while (true) {
            search.search_fun(link)

            while (search.complete == false) {
                Thread.sleep(3000)
            }

            runOnUiThread {
                findViewById<TextView>(R.id.textView2).text = search.text
            }

            search.complete = false
        }
    }
}
