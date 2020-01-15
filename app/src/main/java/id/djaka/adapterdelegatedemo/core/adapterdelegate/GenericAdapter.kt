package id.djaka.adapterdelegatedemo.core.adapterdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Djaka Pradana on 2020-01-08.
 */

class GenericAdapter<T>(var items: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegateManager = AdapterDelegateManager<T>()

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

    fun addDelegate(delegate: AdapterDelegate<T>) {
        delegateManager.addDelegate(delegate)
    }

}