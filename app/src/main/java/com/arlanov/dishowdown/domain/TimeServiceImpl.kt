package com.arlanov.dishowdown.domain

import java.util.*

class TimeServiceImpl : TimeService {
    override fun getHourOFDay(): Int {
        val cal = Calendar.getInstance()

        return cal.get(Calendar.HOUR_OF_DAY)
    }
}