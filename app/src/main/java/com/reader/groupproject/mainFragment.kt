package com.reader.groupproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
lateinit var viewModel: MainViewModel
class MainFragment : Fragment() {


    private val adapter  = RssAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val rssListView: RecyclerView = view.findViewById(R.id.recycler_view)
        rssListView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        rssListView.itemAnimator = DefaultItemAnimator()
        rssListView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.articleList.observe(
            this,
            Observer {
                adapter.submitList(it)
            })

        return view
    }
}
