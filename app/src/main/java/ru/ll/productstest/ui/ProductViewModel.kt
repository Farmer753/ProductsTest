package ru.ll.productstest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    @Preview(widthDp = 180, heightDp = 200)
    @Composable
    fun ColumnSample() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            repeat(5) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.9f)
                        .height(36.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}