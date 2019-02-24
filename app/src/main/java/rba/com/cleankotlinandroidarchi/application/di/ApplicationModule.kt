package rba.com.cleankotlinandroidarchi.application.di

import com.welovegroup.football.android.usecase.di.interfaceAdapterModule
import com.welovegroup.football.android.usecase.di.useCaseModule
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import rba.com.cleankotlinandroidarchi.article.data.database.ArticleLocalDataSource
import rba.com.cleankotlinandroidarchi.article.data.remote.ArticleRemoteDataSource
import rba.com.cleankotlinandroidarchi.article.data.remote.ArticleRetrofitDataSource
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.ArticleViewModel
import rba.com.cleankotlinandroidarchi.usecase.article.data.ArticleRepository
import rba.com.cleankotlinandroidarchi.usecase.article.data.source.ArticleDataSource

val applicationModule = module {
    viewModel { ArticleViewModel(get()) }

    single { ArticleRetrofitDataSource.Creator.newArticleRetrofitDataSource() }
    single { ArticleRepository(ArticleRemoteDataSource(get(), get()), ArticleLocalDataSource()) as ArticleDataSource }
}

val applicationInjectionsModules = listOf(
    applicationModule,
    interfaceAdapterModule,
    useCaseModule,
    mapperModule
)
