package rba.com.cleankotlinandroidarchi.interfaceadapter.article

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleView
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.ErrorState
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.LoadingState
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.RxViewModel
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.State

class ArticleViewModel(
    private val articleManager: ArticleManager
) : RxViewModel() {

    private val mStates = MutableLiveData<State>()
    val states: LiveData<State>
        get() = mStates

    fun observeArticle(id: Int) {
        mStates.value = LoadingState
        launch {
            articleManager.getArticle(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(this::onArticleReceive, this::onError)
        }
    }

    private fun onArticleReceive(articleView: ArticleView) {
        mStates.value = ArticleState(articleView)
    }

    private fun onError(error: Throwable) {
        mStates.value = ErrorState(error)
    }

    data class ArticleState(val articleView: ArticleView) : State()
}