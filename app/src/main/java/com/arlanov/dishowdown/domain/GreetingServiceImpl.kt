package com.arlanov.dishowdown.domain

class GreetingServiceImpl(
    private val messageData: MessageData,
    private val timeService: TimeService
): GreetingService {
    override fun greetings(): String {
        val timeofDay = when(timeService.getHourOFDay()){
            in 7..11 -> "morning"
            in 17..23 -> "evening"
            else -> "day"
        }

        return "Good $timeofDay, ${messageData.welcomeMessage}"
    }
}