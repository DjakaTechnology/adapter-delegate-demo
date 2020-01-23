package id.djaka.adapterdelegatedemo.example.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.djaka.adapterdelegatedemo.R
import id.djaka.adapterdelegatedemo.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_story)

        intent.extras?.let { binding.itemModel = it.getParcelable(ITEM_PARCEL) }
    }

    companion object {
        const val ITEM_PARCEL = "ITEM_PARCEL"
    }
}
