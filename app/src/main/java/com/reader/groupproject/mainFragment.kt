package com.reader.groupproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainFragment : Fragment() {
 lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.articleList.observe(
            this,
            Observer {

            })

        return view
    }
}
