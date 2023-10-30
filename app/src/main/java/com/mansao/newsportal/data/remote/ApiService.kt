package com.mansao.newsportal.data.remote

import com.mansao.newsportal.BuildConfig


interface ApiService {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }
}