package com.mansao.newsportal.ui.screen.home

import androidx.compose.runtime.Composable
import com.mansao.newsportal.data.remote.response.ArticlesItem
import com.mansao.newsportal.ui.common.HomeUiState

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
    println(news[3])
}