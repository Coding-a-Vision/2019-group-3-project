package com.reader.groupproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prof.rssparser.Article

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

//            holder.itemView.setOnClickListener {
//                val bundle = Bundle()
//                bundle.putLong("id", listItem.noteId)
//                holder.itemView.findNavController().navigate(R.id.detailScreen, bundle)
//                viewModel.send(ListEvent.GetNote(listItem.noteId))
//            }
//
//            holder.check.setOnClickListener {
//                viewModel.send(
//                    ListEvent.ModifyNote(
//                        Note(
//                            noteId = listItem.noteId,
//                            note = holder.note.text.toString(),
//                            checked = holder.check.isChecked
//                        )
//                    )
//                )
//            }
//        }
        }
    }

    class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<View>(R.id.title_text) as TextView
        val date = itemView.findViewById<View>(R.id.date_text) as TextView
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
