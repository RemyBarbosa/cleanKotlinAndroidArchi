package com.welovegroup.football.android.usecase.di

import org.koin.dsl.module.module
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.ArticleManager

val interfaceAdapterModule = module {
    single { ArticleManager(get(), get()) }
}
