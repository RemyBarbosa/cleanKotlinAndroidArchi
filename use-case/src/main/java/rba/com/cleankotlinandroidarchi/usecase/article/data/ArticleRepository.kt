package rba.com.cleankotlinandroidarchi.usecase.article.data

import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.entity.article.Article
import rba.com.cleankotlinandroidarchi.usecase.article.data.source.ArticleDataSource

class ArticleRepository(
    private val articleRemoteDataSource: ArticleDataSource,
    private val articleLocalDataSource: ArticleDataSource
) : ArticleDataSource {

    override fun getArticle(number: Int): Flowable<Article> =
        articleRemoteDataSource.getArticle(number).startWith(articleLocalDataSource.getArticle(number))
}
