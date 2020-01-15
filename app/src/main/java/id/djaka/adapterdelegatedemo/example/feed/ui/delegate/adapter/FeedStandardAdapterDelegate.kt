package id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.item.FeedItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStandardItem
import kotlinx.android.synthetic.main.feed_standard_item.view.*

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

class FeedStandardAdapterDelegate : AdapterDelegate<FeedItem> {
    override fun isForViewType(items: List<FeedItem>, position: Int): Boolean {
        return items[position] is FeedStandardItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemStandardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.feed_standard_item, parent, false)
        )
    }

    override fun onBindViewHolder(items: List<FeedItem>, position: Int, holder: RecyclerView.ViewHolder) {
        (holder as ItemStandardViewHolder).bind(items[position] as FeedStandardItem)
    }

    class ItemStandardViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: FeedStandardItem) {
            itemView.text_title.text = item.title
            itemView.text_author.text = item.author
            itemView.text_duration.text = item.duration
            Glide.with(itemView.image_main.context).load(item.imageUrl).into(itemView.image_main)
        }
    }

}