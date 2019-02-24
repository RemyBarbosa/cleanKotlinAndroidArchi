package rba.com.cleankotlinandroidarchi.interfaceadapter.article.model

import rba.com.cleankotlinandroidarchi.entity.article.Article

data class ArticleView(
    val title: String,
    val url: String,
    val creationDate: String
) {
    class Mapper {
        fun fromEntity(article: Article) = ArticleView(
            title = article.title,
            url = article.url,
            creationDate = article.creationDate.toString()
        )
    }
}
