package id.djaka.adapterdelegatedemo.core.adapterdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Djaka Pradana on 2020-01-08.
 */

class AdapterDelegateManager<T> {

    private val delegates = mutableListOf<AdapterDelegate<T>>()

    fun addDelegate(delegate: AdapterDelegate<T>) {
        delegates.add(delegate)
    }

    fun getItemViewType(items: List<T>, position: Int): Int {
        delegates.forEachIndexed { index, it ->  if (it.isForViewType(items, position)) return index }
        throw IllegalStateException("Adapter Delegate for specified type at index: $position not found")
    }

    fun onBindViewHolder(items: List<T>, position: Int, viewHolder: RecyclerView.ViewHolder) {
        delegates[getItemViewType(items, position)].onBindViewHolder(items, position, viewHolder)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
    }
}