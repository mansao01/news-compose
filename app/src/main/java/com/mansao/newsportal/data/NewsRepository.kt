package com.mansao.newsportal.data

import com.mansao.newsportal.data.remote.ApiService
import com.mansao.newsportal.data.remote.response.NewsResponse


interface NewsRepository {
    suspend fun getHeadlineNews(): NewsResponse
}

class NewsRepositoryImpl(
    private val apiService: ApiService
) : NewsRepository {
    override suspend fun getHeadlineNews(): NewsResponse {
        return apiService.getHeadlineNews()
    }
}