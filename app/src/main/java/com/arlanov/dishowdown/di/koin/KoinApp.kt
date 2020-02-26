package com.arlanov.dishowdown.di.koin

import android.app.Application
import com.arlanov.dishowdown.domain.*
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            modules(networkModule)
//        }
    }
}