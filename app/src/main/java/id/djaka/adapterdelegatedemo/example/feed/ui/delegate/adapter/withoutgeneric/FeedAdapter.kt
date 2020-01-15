package id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.withoutgeneric

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegateManager
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedPostAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStandardAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStoryAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.item.FeedItem

/**
 * Created by Djaka Pradana on 2020-01-15.
 */


//If you dont want to use GenericAdapter
class FeedAdapter(var items: List<FeedItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegateManager = AdapterDelegateManager<FeedItem>()

    init {
        delegateManager.run {
            addDelegate(FeedPostAdapterDelegate())
            addDelegate(FeedStandardAdapterDelegate())
            addDelegate(FeedStoryAdapterDelegate())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateManager.onBindViewHolder(items, position, holder)
    }

    override fun getItemViewType(position: Int): Int {
        return delegateManager.getItemViewType(items, position)
    }

}