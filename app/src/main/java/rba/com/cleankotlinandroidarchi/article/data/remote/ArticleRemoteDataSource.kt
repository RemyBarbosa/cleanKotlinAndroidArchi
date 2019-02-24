package rba.com.cleankotlinandroidarchi.article.data.remote

import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.entity.article.Article
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleRemote
import rba.com.cleankotlinandroidarchi.usecase.article.data.source.ArticleDataSource

class ArticleRemoteDataSource(
    private val mapper: ArticleRemote.Mapper,
    private val articleRetrofitDataSource: ArticleRetrofitDataSource
) : ArticleDataSource {

    override fun getArticle(number: Int): Flowable<Article> =
        articleRetrofitDataSource.getArticle(number).map { mapper.toEntity(it) }
}
