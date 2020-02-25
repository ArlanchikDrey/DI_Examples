package com.arlanov.dishowdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlanov.dishowdown.domain.GreetingService
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val greetingService by inject<GreetingService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeNow.text = greetingService.greetings()
    }
}
