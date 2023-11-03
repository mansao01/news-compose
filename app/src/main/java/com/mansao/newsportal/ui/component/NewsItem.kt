package com.mansao.newsportal.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mansao.newsportal.data.remote.response.ArticlesItem

@Composable
fun NewsItemList(
    news: ArticlesItem
) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .crossfade(true)
                    .data(news.urlToImage)
                    .build(), contentDescription = "news image",
                modifier = Modifier.size(204.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            )

            Text(text = news.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)


    }
}