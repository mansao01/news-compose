package com.mansao.newsportal.data.remote

import com.mansao.newsportal.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getHeadlineNews(
        @Query("country")
        country: String = "us"
    ): NewsResponse
}