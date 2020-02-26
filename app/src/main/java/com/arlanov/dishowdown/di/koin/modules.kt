package com.arlanov.dishowdown.di.koin

import com.arlanov.dishowdown.domain.network.RequestServiceImpl
import com.arlanov.dishowdown.domain.network.ResponseService
import com.arlanov.dishowdown.domain.network.ResponseServiceImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { OkHttpClient() }
    single { RequestServiceImpl("https://yandex.ru").getRequest()}
    single<ResponseService> { ResponseServiceImpl(get(),get()) }
}