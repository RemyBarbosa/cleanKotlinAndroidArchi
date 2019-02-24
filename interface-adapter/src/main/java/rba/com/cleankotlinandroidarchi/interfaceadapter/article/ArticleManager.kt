package rba.com.cleankotlinandroidarchi.interfaceadapter.article

import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleView
import rba.com.cleankotlinandroidarchi.usecase.article.GetArticleUseCase


class ArticleManager(
    private val getArticleUseCase: GetArticleUseCase,
    private val mapper: ArticleView.Mapper
) {

    fun getArticle(number: Int): Flowable<ArticleView> {
        return getArticleUseCase.execute(number).map { mapper.fromEntity(it) }
    }
}
