package com.mansao.newsportal.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mansao.newsportal.ui.screen.home.HomeScreen
import com.mansao.newsportal.ui.screen.home.HomeViewModel

@Composable
fun NewsPortalApp() {
    val homeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory.Factory)
    HomeScreen(uiState = homeViewModel.uiState)
}