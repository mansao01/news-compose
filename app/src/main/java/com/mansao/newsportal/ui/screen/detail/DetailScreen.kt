package com.mansao.newsportal.ui.screen.detail

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.viewinterop.AndroidView
import com.mansao.newsportal.data.remote.response.ArticlesItem
import com.mansao.newsportal.ui.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    sharedViewModel: SharedViewModel,
    navigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val news = sharedViewModel.news

    Scaffold(
        topBar = {
            DetailTopBar(news = news, navigateToHome = navigateToHome)
        }
    ) {
//        note: you can not give webView a surface
        AndroidView(factory = {
            WebView(context).apply {
                webViewClient = WebViewClient()
                news?.url?.let { news -> loadUrl(news) }
            }
        }, modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    news: ArticlesItem?,
    navigateToHome: () -> Unit
) {
    TopAppBar(
        title = {
            news?.title?.let { title ->
                Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        },
        navigationIcon = {
            IconButton(onClick = { navigateToHome() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }
        }
    )
}

