package rba.com.cleankotlinandroidarchi.article.data.database

import io.reactivex.Flowable
import org.joda.time.DateTime
import rba.com.cleankotlinandroidarchi.entity.article.Article
import rba.com.cleankotlinandroidarchi.usecase.article.data.source.ArticleDataSource

class ArticleLocalDataSource : ArticleDataSource {

    override fun getArticle(number: Int): Flowable<Article> {
        return Flowable.just<Article>(Article("title", "http://www.foo.com", DateTime.now()))
    }
}
