package id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.item.FeedItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStoryItem
import id.djaka.adapterdelegatedemo.example.story.adapter.StoryStandardAdapter
import kotlinx.android.synthetic.main.feed_story_item.view.*

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

class FeedStoryAdapterDelegate : AdapterDelegate<FeedItem> {
    override fun isForViewType(items: List<FeedItem>, position: Int): Boolean {
        return items[position] is FeedStoryItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemStoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.feed_story_item, parent, false))
    }

    override fun onBindViewHolder(items: List<FeedItem>, position: Int, holder: RecyclerView.ViewHolder) {
        (holder as ItemStoryViewHolder).bind(items[position] as FeedStoryItem)
    }

    inner class ItemStoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val adapter = StoryStandardAdapter()

        init {
            itemView.rv_story.adapter = adapter
            itemView.rv_story.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemView.rv_story.addItemDecoration(DividerItemDecoration(itemView.context, DividerItemDecoration.HORIZONTAL).apply {
                ContextCompat.getDrawable(itemView.context, R.drawable.divider_spacing)?.let { setDrawable(it) }
            })
        }

        fun bind(item: FeedStoryItem) {
            adapter.items = item.stories
            adapter.notifyDataSetChanged()
        }
    }

}