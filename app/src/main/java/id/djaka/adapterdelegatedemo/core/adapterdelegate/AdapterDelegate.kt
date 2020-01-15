package id.djaka.adapterdelegatedemo.core.adapterdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Djaka Pradana on 2020-01-08.
 */

interface AdapterDelegate <T> {
    fun isForViewType(items: List<T>, position: Int): Boolean

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(items: List<T>, position: Int, holder: RecyclerView.ViewHolder)
}