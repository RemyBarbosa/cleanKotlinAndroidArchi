package rba.com.cleankotlinandroidarchi.application.di

import org.koin.dsl.module.module
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleRemote
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleView

val mapperModule = module {
    single { ArticleView.Mapper() }
    single { ArticleRemote.Mapper() }
}
