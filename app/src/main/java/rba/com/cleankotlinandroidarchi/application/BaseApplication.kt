package rba.com.cleankotlinandroidarchi.application

import android.app.Application
import org.koin.android.ext.android.startKoin
import rba.com.cleankotlinandroidarchi.application.di.applicationInjectionsModules

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, applicationInjectionsModules)
    }
}