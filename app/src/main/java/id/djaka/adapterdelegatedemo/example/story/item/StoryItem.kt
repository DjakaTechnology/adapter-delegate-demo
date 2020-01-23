package id.djaka.adapterdelegatedemo.example.story.item

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

@Parcelize
data class StoryItem(
    val author: String,
    val imageUrl: String
) : Parcelable