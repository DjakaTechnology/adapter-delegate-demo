package id.djaka.adapterdelegatedemo.example.feed.ui.old.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.example.feed.item.FeedItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedPostItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStandardItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStoryItem
import id.djaka.adapterdelegatedemo.example.story.adapter.StoryStandardAdapter
import kotlinx.android.synthetic.main.feed_post_item.view.*
import kotlinx.android.synthetic.main.feed_standard_item.view.*
import kotlinx.android.synthetic.main.feed_standard_item.view.image_main
import kotlinx.android.synthetic.main.feed_standard_item.view.text_author
import kotlinx.android.synthetic.main.feed_story_item.view.*

/**
 * Created by Djaka Pradana on 2020-01-08.
 */

class FeedAdapterOld(var items: List<FeedItem> = listOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is FeedPostItem -> ITEM_POST_ID
            is FeedStandardItem -> ITEM_STANDARD_ID
            is FeedStoryItem -> ITEM_STORY_ID
            else -> -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_STANDARD_ID) {
            ItemStandardViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.feed_standard_item,
                    parent,
                    false
                )
            )
        } else if (viewType == ITEM_POST_ID) {
            ItemPostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.feed_post_item, parent, false)
            )
        } else {
            ItemStoryViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.feed_story_item, parent, false)
            )
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == ITEM_STANDARD_ID && holder is ItemStandardViewHolder) {
            holder.bind(items[position] as FeedStandardItem)
        } else if (holder.itemViewType == ITEM_POST_ID && holder is ItemPostViewHolder) {
            holder.bind(items[position] as FeedPostItem)
        } else if (holder.itemViewType == ITEM_STORY_ID && holder is ItemStoryViewHolder) {
            holder.bind(items[position] as FeedStoryItem)
        }
    }


    class ItemPostViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: FeedPostItem) {
            itemView.text_author.text = item.author
            itemView.text_content.text = item.content
            itemView.text_sub.text = item.subtitle
            Glide.with(itemView.image_main.context).load(item.imageUrl).into(itemView.image_main)
        }
    }

    class ItemStandardViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: FeedStandardItem) {
            itemView.text_author.text = item.title
            itemView.text_author.text = item.author
            itemView.text_duration.text = item.duration
            Glide.with(itemView.image_main.context).load(item.imageUrl).into(itemView.image_main)
        }
    }

    class ItemStoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
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

    companion object {
        const val ITEM_STANDARD_ID = 0
        const val ITEM_POST_ID = 1
        const val ITEM_STORY_ID = 2
    }
}