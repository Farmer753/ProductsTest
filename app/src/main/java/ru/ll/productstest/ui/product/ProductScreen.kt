package ru.ll.productstest.ui.product

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ll.productstest.R
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.ui.debugPlaceholder
import ru.ll.productstest.ui.theme.Dark12
import ru.ll.productstest.ui.theme.Dark60
import ru.ll.productstest.ui.theme.ProductsTestTheme


@Preview
@Composable
fun ProductPreview() {
    ProductsTestTheme {
        ProductScreen()
    }
}

@Composable
fun ProductScreen() {

    Column(modifier = Modifier) {
        Row {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .wrapContentHeight()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic24_arrow_left),
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
//                    .wrapContentWidth()
                    .wrapContentHeight()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Divider(color = Dark12, thickness = 1.dp)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            AsyncImage(
                model = UiProduct.TOM,
                contentDescription = "test",
                placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            PointsView()
            Box(modifier = Modifier.padding(16.dp, 12.dp)) {
                Button(
                    onClick = { },
                    modifier = Modifier.size(86.dp, 42.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "-15%",
                        color = Color.White
                    )
                }
            }
            ProductTitleView()
            ProductDetailsView()
        }
    }
}

@Composable
fun ProductTitleView() {
    Column(
        modifier = Modifier.padding(16.dp, 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "Арт. 24764168",
            style = MaterialTheme.typography.body1.copy(color = Dark60)
        )
        Text(
            text = "Грунтовка Eskaro Aquastop Contact адгез. для невпит./поверх. 1,5 кг",
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun ProductDetailsView() {
    Row(
        modifier = Modifier.padding(16.dp, 13.dp)
    ) {
        Text(
            text = "2 200 P",
            style = MaterialTheme.typography.body1.copy(color = Dark60),
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()

        )
//        Box(modifier = Modifier.padding(8.dp)){
            Text(
                text = "2 500 P",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            )
//        }
//            Canvas(modifier = Modifier.fillMaxSize()) {
//
//                // Fetching width and height for
//                // setting start x and end y
//                val canvasWidth = size.width
//                val canvasHeight = size.height
//
//                // drawing a line between start(x,y) and end(x,y)
//                drawLine(
//                    start = Offset(x = canvasWidth, y = 0f),
//                    end = Offset(x = 0f, y = canvasHeight),
//                    color = Color.Red,
//                    strokeWidth = 5F
//                )
//            }
    }
}


@Composable
fun PointsView() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp)
    ) {
        // Creating a Canvas to draw a Circle
        Canvas(modifier = Modifier.size(5.dp)) {
            drawCircle(
                color = Color.Black,
                radius = size.minDimension / 2
            )
        }
        Canvas(modifier = Modifier.size(5.dp)) {
            drawCircle(
                color = Color.Gray,
                radius = size.minDimension / 2
            )
        }
        Canvas(modifier = Modifier.size(5.dp)) {
            drawCircle(
                color = Color.Gray,
                radius = size.minDimension / 2
            )
        }
    }
}


