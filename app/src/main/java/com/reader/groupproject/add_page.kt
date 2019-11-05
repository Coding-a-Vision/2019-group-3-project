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
    val search = search_class()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_page)

        val resultText = findViewById<TextView>(R.id.textView2)
        val searchView = findViewById<SearchView>(R.id.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String): Boolean {
                search.search_fun(s)
                resultText.text = search.text
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                search.search_fun(s)
                resultText.text = search.text
                return true
            }
        })
    }
}
