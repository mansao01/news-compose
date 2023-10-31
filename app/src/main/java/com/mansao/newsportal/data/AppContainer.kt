package com.mansao.newsportal.data

import com.mansao.newsportal.data.remote.ApiService

interface AppContainer {
    val newsRepository: NewsRepository
}

class DefaultAppContainer(
    private val apiService: ApiService
) : AppContainer {
    override val newsRepository: NewsRepository by lazy {
        NewsRepositoryImpl(apiService)
    }
}