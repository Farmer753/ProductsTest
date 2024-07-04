package ru.ll.productstest.ui.categoryproducts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ll.productstest.R
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.domain.test
import ru.ll.productstest.ui.debugPlaceholder
import ru.ll.productstest.ui.theme.Dark12
import ru.ll.productstest.ui.theme.Dark60
import ru.ll.productstest.ui.theme.ProductsTestTheme

@Preview
@Composable
fun CatalogPreview() {
    ProductsTestTheme {
        CategoryProductsScreen("")
    }
}

@Composable
fun CategoryProductsScreen(
    categorySlug: String,
    onProductClick: (UiProduct) -> Unit = {}
) {
    Column {
        val products: MutableState<List<UiProduct>> = remember {
            mutableStateOf(
                (1..100).map { test() }
            )
        }
        Products(
            modifier = Modifier.weight(1f),
            products.value
        ) {
            onProductClick(it)
        }
    }
}

@Composable
fun Products(
    modifier: Modifier = Modifier,
    products: List<UiProduct>,
    onClick: (UiProduct) -> Unit
) {
    val state = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products) { product ->
            Product(product = product, onClick = onClick)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Product(
    product: UiProduct,
    onClick: (UiProduct) -> Unit
) {
    Card(
        onClick = { onClick(product) }
    ) {
        Row {
            Column {
                Box(modifier = Modifier.padding(16.dp, 12.dp)) {
                    AsyncImage(
                        model = UiProduct.TOM,
                        contentDescription = "test",
                        placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
                        modifier = Modifier
                            .size(114.dp, 101.dp)

                    )
                    Button(
                        onClick = { },
                        modifier = Modifier.size(72.dp, 35.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(
                            text = "-15%",
                            color = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 40.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Арт. 24764168",
                    style = MaterialTheme.typography.body1.copy(color = Dark60)
                )
                Text(
                    text = "Блок фундаментный бетоный 190х190х390мм",
                    style = MaterialTheme.typography.h6
                )
                Row {
                    Text(
                        text = "2 200 P",
                        style = MaterialTheme.typography.body1.copy(color = Dark60),
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()

                    )
                    Box(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "2 500 P",
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                        )

                        Canvas(modifier = Modifier.size(21.dp)) {

                            // Fetching width and height for
                            // setting start x and end y
                            val canvasWidth = size.width
                            val canvasHeight = size.height

                            // drawing a line between start(x,y) and end(x,y)
                            drawLine(
                                start = Offset(x = canvasWidth * 3, y = 0f),
                                end = Offset(x = 0f, y = canvasHeight),
                                color = Color.Red,
                                strokeWidth = 5F
                            )
                        }
                    }
                }
            }
            Divider(color = Dark12, thickness = 1.dp)
        }
    }
}
