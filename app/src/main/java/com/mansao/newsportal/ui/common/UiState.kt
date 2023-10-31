package com.mansao.newsportal.ui.common

import com.mansao.newsportal.data.remote.response.NewsResponse

sealed interface HomeUiState {
    object Loading : HomeUiState

    data class Success(val newsResponse: NewsResponse) : HomeUiState

    data class Error(val message: String) : HomeUiState
}