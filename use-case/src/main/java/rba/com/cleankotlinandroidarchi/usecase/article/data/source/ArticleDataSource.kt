package rba.com.cleankotlinandroidarchi.usecase.article.data.source

import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.entity.article.Article

interface ArticleDataSource {
    fun getArticle(number: Int): Flowable<Article>
}
