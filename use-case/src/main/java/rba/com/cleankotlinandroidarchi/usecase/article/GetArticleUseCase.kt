package rba.com.cleankotlinandroidarchi.usecase.article


import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.entity.article.Article
import rba.com.cleankotlinandroidarchi.usecase.article.data.source.ArticleDataSource

class GetArticleUseCase(
    private val articleDataSource: ArticleDataSource
) {
    fun execute(number: Int): Flowable<Article> {
        return articleDataSource.getArticle(number)
    }
}
