package com.mpn.pagerissuesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mpn.pagerissuesample.ui.theme.PagerIssueSampleTheme

val pageNumber = 5

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var showDialog by remember {
                mutableStateOf(false)
            }

            PagerIssueSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    if (showDialog) {
                        SampleDialog(
                            initialPage = pageNumber - 2,
                            onDismiss = { showDialog = false }
                        )
                    }

                    Button(
                        onClick = { showDialog = true }
                    ) {
                        Text("Show dialog")
                    }
                }
            }
        }
    }
}