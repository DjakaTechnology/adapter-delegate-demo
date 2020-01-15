package id.djaka.adapterdelegatedemo.example.feed.ui.old

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.Utils
import id.djaka.adapterdelegatedemo.example.feed.ui.old.adapter.FeedAdapterOld
import kotlinx.android.synthetic.main.activity_old.*

class OldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        rv_old.adapter = FeedAdapterOld(Utils.getFeedItems())
        rv_old.layoutManager = LinearLayoutManager(this)
        rv_old.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
