package com.arlanov.dishowdown.domain.network

import okhttp3.Response

interface ResponseService {
    suspend fun getTitle(): String?
}