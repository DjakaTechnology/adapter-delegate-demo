package id.djaka.adapterdelegatedemo.example.feed.ui.delegate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import id.djaka.adapterdelegatedemo.databinding.StoryStandardItemBinding
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedPostAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStandardAdapterDelegate
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.adapter.FeedStoryAdapterDelegate
import id.djaka.adapterdelegatedemo.example.story.StoryActivity
import id.djaka.adapterdelegatedemo.example.story.item.StoryItem
import kotlinx.android.synthetic.main.activity_delegate.*
import androidx.core.util.Pair

class DelegateActivity : AppCompatActivity() {
    private val adapter = GenericAdapter(Utils.getFeedItems()).apply {
        addDelegate(FeedPostAdapterDelegate())
        addDelegate(FeedStandardAdapterDelegate())
        addDelegate(FeedStoryAdapterDelegate { binding: StoryStandardItemBinding, storyItem: StoryItem ->
            startStoryActivity(binding, storyItem)
        })
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

    //Bonus Launch activity with shared transition
    private fun startStoryActivity(binding: StoryStandardItemBinding, item: StoryItem) {
        val intent = Intent(this, StoryActivity::class.java)
        intent.putExtra(StoryActivity.ITEM_PARCEL, item)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            Pair(binding.cardMain as View, "cardMain"),
            Pair(binding.image as View, "image"),
            Pair(binding.imageForeground as View, "imageForeground"),
            Pair(binding.imageProfile as View, "imageProfile"),
            Pair(binding.textAuthor as View, "textAuthor")
        )

        startActivity(intent, options.toBundle())
    }
}
