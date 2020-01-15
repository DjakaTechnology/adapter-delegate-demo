package id.djaka.adapterdelegatedemo

import id.djaka.adapterdelegatedemo.example.chat.item.MessageItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedPostItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStandardItem
import id.djaka.adapterdelegatedemo.example.feed.item.FeedStoryItem
import id.djaka.adapterdelegatedemo.example.story.item.StoryItem

/**
 * Created by Djaka Pradana on 2020-01-06.
 */

object Utils {
    fun getMyId() = 0

    fun getMessageItem() = listOf(
        MessageItem(
            1,
            "Jaskier",
            "Toss a coin to your witcher"
        ),
        MessageItem(0, "Geralt", "Hmmm"),
        MessageItem(
            1,
            "Jaskier",
            "Ooh valley of plenty ooh valley of plenty"
        ),
        MessageItem(
            0,
            "Geralt",
            "Silence, I'll let kikimora hunt you"
        ),
        MessageItem(1, "Jaskier", ":((")
    )

    fun getFeedItems() = listOf(
        FeedPostItem(
            "Chillin",
            "Hey guys cant believe this view is so good! (Feed Post)",
            "https://cosmos-images2.imgix.net/file/spina/photo/20565/191010_nature.jpg?ixlib=rails-2.1.4&auto=format&ch=Width%2CDPR&fit=max&w=835"
        ),
        FeedStandardItem(
            "Elon Musk & Jack Ma",
            "Dunno (Feed Standard)",
            "https://image.businessinsider.com/5d67e2c22e22af0d6c167276?width=1100&format=jpeg&auto=webp",
            "3:14"
        ),
        FeedStoryItem(
          getStoryItem()
        ),
        FeedStandardItem(
            "Tifa is Looking Great in FF7 Remake",
            "FF7 Remake (Feed Standard)",
            "http://cdn3.whatculture.com/images/2019/12/20cf4f39f942b7a5-600x338.jpg",
            "3:14"
        ),
        FeedPostItem(
            "Coca cola",
            "Here some coca cola (Feed Post)",
            "https://turbologo.com/articles/wp-content/uploads/2019/08/coca-cola-logo-2007.jpg"
        )
    )

    fun getStoryItem() = listOf(
        StoryItem(
            "Djaka Pradana",
            "https://avatars0.githubusercontent.com/u/19620593?s=400&v=4"
        ),
        StoryItem(
            "Tzuyu",
            "https://cdn.idntimes.com/content-images/community/2019/07/tzuyu732-09d5b73167ac0ced1c589074f0f36d8c_600x400.jpeg"
        ),
        StoryItem(
            "Geralt",
            "https://vignette.wikia.nocookie.net/witcher/images/5/51/Netflix_geralt_shirt.jpg/revision/latest?cb=20191228182240"
        ),
        StoryItem(
            "Goose \n(don't mind me)",
            "https://upload.wikimedia.org/wikipedia/commons/3/39/Domestic_Goose.jpg"
        )
    )
}