package com.reader.groupproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class addPageFragment : Fragment() {

    val search = search_class()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_page, container, false)
        val resultText = view.findViewById<TextView>(R.id.textView2)
        val searchView = view.findViewById<SearchView>(R.id.search)
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
        return view
    }
}
