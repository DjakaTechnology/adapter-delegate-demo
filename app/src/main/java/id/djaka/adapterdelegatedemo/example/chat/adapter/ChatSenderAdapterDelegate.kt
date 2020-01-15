package id.djaka.adapterdelegatedemo.example.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import id.djaka.adapterdelegatedemo.databinding.ChatSenderItemBinding
import id.djaka.adapterdelegatedemo.example.chat.item.MessageItem

/**
 * Created by Djaka Pradana on 2020-01-16.
 */

class ChatSenderAdapterDelegate : AdapterDelegate<MessageItem> {
    override fun isForViewType(items: List<MessageItem>, position: Int): Boolean {
        return items[position].id == Utils.getMyId()
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.chat_sender_item, parent, false))
    }

    override fun onBindViewHolder(items: List<MessageItem>, position: Int, holder: RecyclerView.ViewHolder) {
        (holder as ViewHolder).binding.itemModel = items[position]
    }

    inner class ViewHolder(val binding: ChatSenderItemBinding): RecyclerView.ViewHolder(binding.root)

}