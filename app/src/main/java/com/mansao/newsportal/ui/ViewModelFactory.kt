package com.mansao.newsportal.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mansao.newsportal.NewsApplication
import com.mansao.newsportal.ui.screen.home.HomeViewModel

object ViewModelFactory{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(newsApplication().container.newsRepository)
        }
    }
}

fun CreationExtras.newsApplication():NewsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NewsApplication)