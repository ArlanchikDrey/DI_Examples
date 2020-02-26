package com.arlanov.dishowdown.domain.network

import okhttp3.Request

class RequestServiceImpl(
    private val url: String
): RequestService {
    override fun getRequest(): Request {
        return Request.Builder().url(url).build()
    }
}