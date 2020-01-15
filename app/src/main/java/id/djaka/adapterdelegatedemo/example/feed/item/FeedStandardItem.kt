package id.djaka.adapterdelegatedemo.example.feed.item

/**
 * Created by Djaka Pradana on 2020-01-09.
 */

data class FeedStandardItem(
    val title: String,
    val author: String,
    val imageUrl: String,
    val duration: String
): FeedItem