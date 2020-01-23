package id.djaka.adapterdelegatedemo.example.story.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.databinding.StoryStandardItemBinding
import id.djaka.adapterdelegatedemo.example.story.item.StoryItem

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

class StoryStandardAdapter(
    var items: List<StoryItem> = listOf(),
    private var onItemClick: ((StoryStandardItemBinding, StoryItem) -> Unit)? = null
) : RecyclerView.Adapter<StoryStandardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.story_standard_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemModel = items[position]
        holder.binding.cardMain.setOnClickListener { onItemClick?.invoke(holder.binding, items[position]) }
    }

    inner class ViewHolder(val binding: StoryStandardItemBinding): RecyclerView.ViewHolder(binding.root)
}