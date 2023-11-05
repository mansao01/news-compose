package com.mansao.newsportal.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mansao.newsportal.data.remote.response.ArticlesItem
import com.mansao.newsportal.ui.SharedViewModel
import com.mansao.newsportal.ui.common.HomeUiState
import com.mansao.newsportal.ui.component.NewsItemList

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    navigateToDetail: () -> Unit,
    sharedViewModel: SharedViewModel
) {

    when (uiState) {
        is HomeUiState.Loading -> {}
        is HomeUiState.Success -> HomeContent(
            uiState.newsResponse.articles,
            navigateToDetail = navigateToDetail,
            sharedViewModel = sharedViewModel
        )

        is HomeUiState.Error -> {}
    }
}

@Composable
fun HomeContent(
    news: List<ArticlesItem>,
    navigateToDetail: () -> Unit,
    sharedViewModel: SharedViewModel
) {
    LazyColumn {
        items(news) { data ->
            NewsItemList(news = data, modifier = Modifier.clickable {
                sharedViewModel.addNews(data)
                navigateToDetail()
            })
        }
    }
}




