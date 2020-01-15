package id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.item.FeedItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedPostItem
import kotlinx.android.synthetic.main.feed_post_item.view.*

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

class FeedPostAdapterDelegate : AdapterDelegate<FeedItem> {
    override fun isForViewType(items: List<FeedItem>, position: Int): Boolean {
        return items[position] is FeedPostItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemPostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.feed_post_item, parent, false)
        )
    }

    override fun onBindViewHolder(items: List<FeedItem>, position: Int, holder: RecyclerView.ViewHolder) {
        (holder as ItemPostViewHolder).bind(items[position] as FeedPostItem)
    }

    class ItemPostViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: FeedPostItem) {
            itemView.text_author.text = item.author
            itemView.text_content.text = item.content
            Glide.with(itemView.image_main.context).load(item.imageUrl).into(itemView.image_main)
        }
    }

}