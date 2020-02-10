package id.djaka.adapterdelegatedemo.example.feed.item

/**
 * Created by Djaka Pradana on 2020-01-09.
 */

data class FeedPostItem(
    val author: String,
    val content: String,
    val imageUrl: String,
    val subtitle: String
): FeedItem