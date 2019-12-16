package com.reader.groupproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_reader.*

class ReaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reader, container, false)
        val titleView = view.findViewById<TextView>(R.id.reader_title_text)
        val articleText = view.findViewById<WebView>(R.id.article_text)

        val position = arguments?.getInt("id")
        Log.i("position", "${viewModel.articleList.value?.get(position!!)}")
        titleView.text = viewModel.articleList.value?.get(position!!)?.title
        articleText.loadData(
            viewModel.articleList.value?.get(position!!)?.description,
            "text/html",
            "UTF-8"
        )

        return view
    }
}
