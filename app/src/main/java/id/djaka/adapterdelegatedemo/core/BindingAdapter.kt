package id.djaka.adapterdelegatedemo.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImageUrl(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view).load(url).into(view)
        }
    }
}