package id.djaka.adapterdelegatedemo.example.feed.ui.delegate.withoutholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.withoutholder.adapter.FeedPostAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.withoutholder.adapter.FeedStandardAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.withoutholder.adapter.FeedStoryAdapterDelegate
import kotlinx.android.synthetic.main.activity_without_holder.*

class WithoutHolderActivity : AppCompatActivity() {
    private val adapter = GenericAdapter(Utils.getFeedItems())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_holder)

        initAdapter()
        initRV()
    }

    private fun initRV() {
        rv_without_holder.adapter = adapter
        rv_without_holder.layoutManager = LinearLayoutManager(this)
        rv_without_holder.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun initAdapter() {
        adapter.apply {
            addDelegate(FeedPostAdapterDelegate())
            addDelegate(FeedStandardAdapterDelegate())
            addDelegate(FeedStoryAdapterDelegate())
        }
    }
}
