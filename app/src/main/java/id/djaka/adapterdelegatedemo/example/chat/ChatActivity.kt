package id.djaka.adapterdelegatedemo.example.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import id.djaka.adapterdelegatedemo.example.chat.adapter.ChatReceiverAdapterDelegate
import id.djaka.adapterdelegatedemo.example.chat.adapter.ChatSenderAdapterDelegate
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private val adapter = GenericAdapter(Utils.getMessageItem()).apply {
        addDelegate(ChatSenderAdapterDelegate())
        addDelegate(ChatReceiverAdapterDelegate())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        initRV()
    }

    private fun initRV() {
        rv_chat.adapter = adapter
        rv_chat.layoutManager = LinearLayoutManager(this)
        rv_chat.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL).apply {
            ContextCompat.getDrawable(this@ChatActivity, R.drawable.divider_spacing)?.let { setDrawable(it) }
        })
    }
}
