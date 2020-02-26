package com.arlanov.dishowdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.arlanov.dishowdown.domain.network.RequestServiceImpl
import com.arlanov.dishowdown.domain.network.ResponseService
import com.arlanov.dishowdown.domain.network.ResponseServiceImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import org.koin.android.ext.android.inject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var titleService: ResponseServiceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                val text = p0.toString()
                if (text.contains("http://") or text.contains("https://"))
                    start(text)
                else
                    timeNow.text = "null"
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    private fun start(url: String){
        GlobalScope.launch(Dispatchers.Main) {
            progress.visibility = View.VISIBLE
            val text = withContext(Dispatchers.IO) {
                getTitles(url)
            }
            progress.visibility = View.INVISIBLE
            if (text != null) {
                timeNow.text = text
            }else{
                timeNow.text = ""
            }
        }
    }

    private suspend fun getTitles(url: String): String? {
        var text: String?
        try {
            titleService = ResponseServiceImpl(OkHttpClient(),
                RequestServiceImpl(url).getRequest())
            text = titleService.getTitle()
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
            text = null
        }

        return text
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
