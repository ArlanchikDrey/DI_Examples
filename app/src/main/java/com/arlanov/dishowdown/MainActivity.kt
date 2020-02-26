package com.arlanov.dishowdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.arlanov.dishowdown.domain.network.ResponseService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val titleService by inject<ResponseService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            progress.visibility = View.VISIBLE
            val text = withContext(Dispatchers.IO) {
                getTitles()
            }
            progress.visibility = View.INVISIBLE
            if (text != null) {
                timeNow.text = text
            }
        }
    }

    private suspend fun getTitles(): String? {
        val response = titleService.getTitle()
        return response
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
