package com.mpn.pagerissuesample

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@Composable
fun SampleDialog(
    initialPage: Int,
    onDismiss: () -> Unit
) {

    AlertDialog(
        backgroundColor = Color.DarkGray,
        onDismissRequest = { onDismiss() },
        text = {
            SimplePager(initialPage = initialPage)
        },
        confirmButton = {
            Text(
                text = "OK",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .clickable { onDismiss() }
            )
        },
        dismissButton = {
            Text(
                text = "Cancel",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .clickable { onDismiss() }
            )
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SimplePager(initialPage: Int) {

    val pagerState = rememberPagerState()

    if (pagerState.currentPage != initialPage) {
        LaunchedEffect(initialPage, pagerState) {
            if (initialPage <= pagerState.pageCount) {
                Log.d("SimplePager", "Scrolling to $initialPage")
                pagerState.animateScrollToPage(initialPage)
            }
        }
    }


    HorizontalPager(count = pageNumber, state = pagerState) {
        Text(
            text = currentPage.toString(),
            color = Color.Black,
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp)
        )
    }
}