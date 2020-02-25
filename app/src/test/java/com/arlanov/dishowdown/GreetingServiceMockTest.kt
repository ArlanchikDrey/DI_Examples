package com.arlanov.dishowdown

import com.arlanov.dishowdown.di.koin.koinModule
import com.arlanov.dishowdown.domain.GreetingService
import com.arlanov.dishowdown.domain.TimeService
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given

class GreetingServiceMockTest: KoinTest {
    private val greetingService: GreetingService by inject()
    @Test
    fun testGreetingInTheMorning(){
        startKoin { modules(koinModule) }
        declareMock<TimeService> {
            given(this.getHourOFDay()).willReturn(9)
        }
        assertEquals("Good morning, welcome to Koin", greetingService.greetings())
        stopKoin()
    }
}