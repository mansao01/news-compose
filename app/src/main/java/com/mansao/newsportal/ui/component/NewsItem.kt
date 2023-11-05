package com.mansao.newsportal.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mansao.newsportal.util.DateFormatter
import com.mansao.newsportal.data.remote.response.ArticlesItem

@Composable
fun NewsItemList(
    news: ArticlesItem,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val createdAt = DateFormatter.formatDate(news.publishedAt)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .crossfade(true)
                .data(news.urlToImage)
                .build(),
            contentDescription = "news image",
            modifier = Modifier
                .size(204.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            news.title?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                )
            }

            news.source?.name?.let {
                Text(
                    text = it,
                    color = Color.Gray,
                    style = TextStyle(fontWeight = FontWeight.Normal)
                )
            }

            createdAt?.let {
                Text(
                    text = it,
                    color = Color.Gray,
                    style = TextStyle(fontWeight = FontWeight.Normal)
                )
            }
        }
    }
}
