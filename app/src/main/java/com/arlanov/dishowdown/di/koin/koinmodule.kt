package com.arlanov.dishowdown.di.koin

import com.arlanov.dishowdown.domain.*
import org.koin.dsl.module

val koinModule = module {
    single { MessageData("welcome to Koin") }
    single<TimeService> { TimeServiceImpl() }
    single<GreetingService> { GreetingServiceImpl(get(),get()) }
}