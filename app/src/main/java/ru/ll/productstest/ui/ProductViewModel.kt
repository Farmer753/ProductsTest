package ru.ll.productstest.ui

import androidx.annotation.DrawableRes
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
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import ru.ll.productstest.R
import ru.ll.productstest.ui.theme.Dark12
import ru.ll.productstest.ui.theme.Dark60
import ru.ll.productstest.ui.theme.ProductsTestTheme

class ProductViewModel : ViewModel() {

    @Preview
    @Composable
    fun ColumnSamplePreview() {
        ProductsTestTheme {
            ColumnSample()
        }
    }

    @Composable
    fun ColumnSample() {

        Column {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                AsyncImage(
                    model = "https://s3-alpha-sig.figma.com/img/6861/f5d0/b3bbfc363f115fdeba2e726f1f1a6c29?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RlN19IwLYucTqPZ9RGgaIO5OZKMHiZoz9jqaBg7Gexp0DU~o3XA1dUx3-nn9t3QFUqjZMjXvkR1SRtNDZV-oRynBoG2ty4h9Y~qiC-15SU2im-zSG-6E9~YvLjhw~WNSXE0-pP9BHFmkEXqhLl8eSRQo9DrZlng-1ze0hjll79htaF6kKxDzyv6yNlWAEiqjcIL7CZQ6W4m1iq4~S~wRzda6odMpWdSSRVHkGeNxBMsCUpa9hALkPLIAWHSu8~qaOhfX8AcsCNFlrXM1xVErdVYerIEax1kHCKwOqqBmB0xb6gP8aJL0pq6lL8gmMJINfeBesU4i20-XAAN8BumXBA__",
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
//                TODO: corner radius
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
            val data = listOf(
                stringResource(id = R.string.measure) to 400.0,
                stringResource(id = R.string.energyPer100grams) to 198.9,
                stringResource(id = R.string.proteinsPer100grams) to 10.0,
                stringResource(id = R.string.fatsPer100grams) to 8.5,
                stringResource(id = R.string.carbohydratesPer100grams) to 19.7,
            )
            Divider(color = Dark12, thickness = 1.dp)
            data.forEach { (title, value) ->
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
                        text = value.toString(),
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

    @Composable
    fun debugPlaceholder(@DrawableRes debugPreview: Int) =
        if (LocalInspectionMode.current) {
            painterResource(id = debugPreview)
        } else {
            null
        }
}
