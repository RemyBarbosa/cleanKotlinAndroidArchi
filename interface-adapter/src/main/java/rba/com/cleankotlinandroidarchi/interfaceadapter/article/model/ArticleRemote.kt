package rba.com.cleankotlinandroidarchi.interfaceadapter.article.model

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import rba.com.cleankotlinandroidarchi.entity.article.Article

data class ArticleRemote(
    val title: String?,
    val url: String?,
    @SerializedName("created_at") val creationDate: DateTime?
) {
    companion object {
        private const val DEFAULT_TITLE = ""
        private const val DEFAULT_URL = ""
        private val DEFAULT_CREATION_DATE = DateTime.now()
    }

    class Mapper {
        fun toEntity(articleRemote: ArticleRemote) = Article(
            title = articleRemote.title ?: DEFAULT_TITLE,
            url = articleRemote.url ?: DEFAULT_URL,
            creationDate = articleRemote.creationDate ?: DEFAULT_CREATION_DATE
        )
    }
}
