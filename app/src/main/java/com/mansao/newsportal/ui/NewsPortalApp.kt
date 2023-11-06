package com.mansao.newsportal.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mansao.newsportal.ui.navigation.Screen
import com.mansao.newsportal.ui.screen.detail.DetailScreen
import com.mansao.newsportal.ui.screen.home.HomeScreen
import com.mansao.newsportal.ui.screen.home.HomeViewModel

@Composable
fun NewsPortalApp(
    navController: NavHostController = rememberNavController()
) {
    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory.Factory)
            HomeScreen(
                uiState = homeViewModel.uiState,
                navigateToDetail = {
                    navController.navigate(Screen.Detail.route)
                },
                sharedViewModel = sharedViewModel

            )
        }

        composable(Screen.Detail.route) {
            DetailScreen(
                sharedViewModel = sharedViewModel,
                navigateToHome = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                })
        }
    }
}