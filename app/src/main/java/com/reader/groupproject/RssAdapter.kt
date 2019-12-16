package com.reader.groupproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prof.rssparser.Article
import java.text.SimpleDateFormat

class RssAdapter :
    ListAdapter<Article, RssAdapter.ListItemViewHolder>(ListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rss_item, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val listItem = getItem(position)
        listItem.let {
            holder.title.text = it.title
            holder.date.text = it.pubDate
            Glide
                .with(holder.image.context)
                .load(it.image)
                .fitCenter()
                .into(holder.image)

            holder.itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", position)
                Log.i("position", "$position")
                it.findNavController().navigate(R.id.readerFragment, bundle)
            }
        }
    }

    class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<View>(R.id.title_text) as TextView
        val date = itemView.findViewById<View>(R.id.date_text) as TextView
        val image = itemView.findViewById<View>(R.id.image_view) as ImageView
    }

    class ListItemDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}
