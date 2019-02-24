package rba.com.cleankotlinandroidarchi.article

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import rba.com.cleankotlinandroidarchi.R
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.ArticleViewModel
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleView
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.ErrorState
import rba.com.cleankotlinandroidarchi.interfaceadapter.base.LoadingState

class ArticleActivity : AppCompatActivity() {

    private val viewModel by viewModel<ArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
        viewModel.observeArticle(631)
    }

    private fun observeViewModel() {
        viewModel.states.observe(this, Observer { state ->
            state?.let {
                when (state) {
                    is LoadingState -> showLoader()
                    is ErrorState -> showError(state.error)
                    is ArticleViewModel.ArticleState -> showArticle(state.articleView)
                }
            }
        })
    }

    private fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    private fun showArticle(articleView: ArticleView) {
        loader.visibility = View.GONE
        article_detail.text =
            String.format(
                "%s%n"
                        + "%n"
                        + "%s%n"
                        + "%n"
                        + "%s",
                articleView.title,
                articleView.url,
                articleView.creationDate
            )
    }

    private fun showError(error: Throwable) {
        loader.visibility = View.GONE
        error.message?.let { Snackbar.make(main_layout, it, Snackbar.LENGTH_SHORT) }
    }
}
