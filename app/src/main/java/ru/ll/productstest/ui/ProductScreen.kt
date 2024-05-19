package ru.ll.productstest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ll.productstest.R
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.ui.theme.Dark12
import ru.ll.productstest.ui.theme.Dark60
import ru.ll.productstest.ui.theme.ProductsTestTheme


@Preview
@Composable
fun ProductPreview() {
    ProductsTestTheme {
        Product()
    }
}

@Composable
fun Product() {

    Column {
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
            ProductTitleView()
            ProductDetailsView()
        }
        Box(modifier = Modifier.padding(16.dp, 12.dp)) {
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "В корзину за 720 Р",
                    color = Color.White
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = { },
            backgroundColor = Color.White
//                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 1.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic24_arrow_left),
                contentDescription = "back",
                modifier = Modifier
                    .padding(10.dp)
            )
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
            text = "Том Ям",
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Кокосовое молоко, кальмары, креветки,\n" +
                    "помидоры черри, грибы вешанки",
            style = MaterialTheme.typography.body1.copy(color = Dark60)
        )
    }
}

@Composable
fun ProductDetailsView() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val measureUnit = "г"
        val data = listOf(
            Triple(stringResource(id = R.string.measure), 400.0, measureUnit),
            Triple(stringResource(id = R.string.energyPer100grams), 198.9, "ккал"),
            Triple(stringResource(id = R.string.proteinsPer100grams), 10.0, measureUnit),
            Triple(stringResource(id = R.string.fatsPer100grams), 8.5, measureUnit),
            Triple(stringResource(id = R.string.carbohydratesPer100grams), 19.7, measureUnit),
        )
        Divider(color = Dark12, thickness = 1.dp)
        data.forEach { (title, value, measureUnitText) ->
            Row(
                modifier = Modifier.padding(16.dp, 13.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1.copy(color = Dark60),
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()

                )
                Text(
                    text = "$value $measureUnitText",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
            }
            Divider(color = Dark12, thickness = 1.dp)
        }
    }
}