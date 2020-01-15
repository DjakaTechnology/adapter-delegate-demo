package id.djaka.adapterdelegatedemo.example.feed.item

import id.djaka.adapterdelegatedemo.example.story.item.StoryItem

/**
 * Created by Djaka Pradana on 2020-01-14.
 */

data class FeedStoryItem(
    val stories: List<StoryItem>
): FeedItem