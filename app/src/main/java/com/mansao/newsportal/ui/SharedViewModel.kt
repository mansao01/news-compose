package com.mansao.newsportal.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mansao.newsportal.data.remote.response.ArticlesItem

class SharedViewModel : ViewModel() {

    var news by mutableStateOf<ArticlesItem?>(null)
        private set

    fun addNews(newData: ArticlesItem) {
        news = newData
    }
}