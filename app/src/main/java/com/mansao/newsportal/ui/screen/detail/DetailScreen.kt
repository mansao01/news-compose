package com.mansao.newsportal.ui.screen.detail

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.mansao.newsportal.ui.SharedViewModel

@Composable
fun DetailScreen(
    sharedViewModel: SharedViewModel
) {
    val context = LocalContext.current
    val news = sharedViewModel.news
    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()
            news?.url?.let { news -> loadUrl(news) }
        }
    })
}

