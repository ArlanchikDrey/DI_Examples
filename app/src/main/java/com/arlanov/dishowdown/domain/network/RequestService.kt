package com.arlanov.dishowdown.domain.network

import okhttp3.Request

interface RequestService {
    fun getRequest(): Request
}