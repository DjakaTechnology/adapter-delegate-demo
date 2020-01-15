package id.djaka.adapterdelegatedemo.example.feed.ui.delegate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedPostAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStandardAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStoryAdapterDelegate
import kotlinx.android.synthetic.main.activity_delegate.*

class DelegateActivity : AppCompatActivity() {
    private val adapter = GenericAdapter(Utils.getFeedItems()).apply {
        addDelegate(FeedPostAdapterDelegate())
        addDelegate(FeedStandardAdapterDelegate())
        addDelegate(FeedStoryAdapterDelegate())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delegate)

        initRV()
    }

    private fun initRV() {
        rv_without_holder.adapter = adapter
        rv_without_holder.layoutManager = LinearLayoutManager(this)
        rv_without_holder.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
