package com.reader.groupproject


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

lateinit var viewModel: AddPageViewModel

class AddPageFragment : Fragment() {

    val search = search_class()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_page, container, false)
        val resultText = view.findViewById<TextView>(R.id.textView2)
        val searchView = view.findViewById<SearchView>(R.id.search)

        viewModel = ViewModelProviders.of(this).get(AddPageViewModel::class.java)
        viewModel.text.observe(this, Observer { newText ->
            resultText.text = newText.toString()
            Log.i("addPagefragment", "Observer is working")
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(s: String): Boolean {
                search.search_fun(s)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                search.search_fun(s)
                return true
            }
        })
        return view
    }
}
