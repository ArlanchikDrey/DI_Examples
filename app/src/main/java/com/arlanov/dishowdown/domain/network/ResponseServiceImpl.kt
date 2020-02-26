package com.arlanov.dishowdown.domain.network

import okhttp3.*
import java.io.IOException
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class ResponseServiceImpl(
    private val client: OkHttpClient,
    private val request: Request
) : ResponseService {

    override suspend fun getTitle(): String? {
        return suspendCoroutine { continuation ->
            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    continuation.resume(null)
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val text = response.body?.string()
                            ?.substringAfter("<title>")
                            ?.substringBefore("</title>")
                        continuation.resume(text)
                    }else{
                        continuation.resume(null)
                    }
                }

            })
        }

    }
}