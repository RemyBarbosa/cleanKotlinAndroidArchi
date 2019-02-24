package com.welovegroup.football.android.usecase.di

import org.koin.dsl.module.module
import rba.com.cleankotlinandroidarchi.usecase.article.GetArticleUseCase

val useCaseModule = module {
    single { GetArticleUseCase(get()) }
}
