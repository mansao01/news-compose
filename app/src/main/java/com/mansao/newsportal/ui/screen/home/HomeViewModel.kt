package com.mansao.newsportal.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mansao.newsportal.data.NewsRepository
import com.mansao.newsportal.ui.common.HomeUiState
import kotlinx.coroutines.launch

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    var uiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getHeadlineNews()
    }

    private fun getHeadlineNews() {
        viewModelScope.launch {
            uiState = HomeUiState.Loading
            uiState = try {
                val result = newsRepository.getHeadlineNews()
                HomeUiState.Success(result)
            } catch (e: Exception) {
                HomeUiState.Error(e.message.toString())
            }
        }
    }

}