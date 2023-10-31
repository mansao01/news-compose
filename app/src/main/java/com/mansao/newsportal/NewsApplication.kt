package com.mansao.newsportal

import android.app.Application
import com.mansao.newsportal.data.AppContainer
import com.mansao.newsportal.data.DefaultAppContainer
import com.mansao.newsportal.data.remote.ApiConfig

class NewsApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        val apiService = ApiConfig.getApiService()

        container = DefaultAppContainer(
            apiService = apiService
        )
    }
}