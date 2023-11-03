package com.mansao.newsportal.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mansao.newsportal.data.remote.response.ArticlesItem
import com.mansao.newsportal.ui.common.HomeUiState
import com.mansao.newsportal.ui.component.NewsItemList

@Composable
fun HomeScreen(
    uiState: HomeUiState
) {
    when (uiState) {
        is HomeUiState.Loading -> {}
        is HomeUiState.Success -> HomeContent(uiState.newsResponse.articles)
        is HomeUiState.Error -> {}
    }
}

@Composable
fun HomeContent(
    news: List<ArticlesItem>
) {
    LazyColumn {
        items(news) { data ->
            NewsItemList(news = data)
        }
    }
}