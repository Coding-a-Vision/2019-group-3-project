package com.reader.groupproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reader, container, false)
        val titleView = view.findViewById<TextView>(R.id.reader_title_text)
        val articleText = view.findViewById<TextView>(R.id.article_text)
        val imageView = view.findViewById<ImageView>(R.id.image_news)

        val position = arguments?.getInt("id")
        Log.i("position", "${viewModel.articleList.value?.get(position!!)}")
        titleView.text = viewModel.articleList.value?.get(position!!)?.title
        articleText.text = viewModel.articleList.value?.get(position!!)?.description

        Glide
            .with(this)
            .load(viewModel.articleList.value?.get(position!!)?.image)
            .fitCenter()
            .into(imageView)
        return view
    }
}