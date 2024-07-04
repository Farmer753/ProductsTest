package ru.ll.productstest.ui.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ll.productstest.MainActivity
import ru.ll.productstest.R
import ru.ll.productstest.domain.UiCategory
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.domain.test
import ru.ll.productstest.ui.categoryproducts.Product
import ru.ll.productstest.ui.categoryproducts.Products
import ru.ll.productstest.ui.subcatalog.Categories
import ru.ll.productstest.ui.theme.ProductsTestTheme

@Preview
@Composable
fun CatalogPreview() {
    ProductsTestTheme {
        CatalogScreen()
    }
}

@Composable
fun CatalogScreen(
    onCategoryClick: (UiCategory) -> Unit = {},
    onCategorySlugClick: (String) -> Unit = {}
) {


    Column {
            Box(
                modifier = Modifier.padding(16.dp)
            )
            {
                Text(text = "Каталог товаров")
            }
        val products: MutableState<List<UiProduct>> = remember {
            mutableStateOf(
                (1..100).map { test() }
            )
        }
        CatalogStart(
            modifier = Modifier.weight(1f),
            products.value
        ) {
//          TODO
        }
        Box(modifier = Modifier.padding(16.dp, 12.dp)) {

            Button(
                onClick = { onCategorySlugClick("hhh") },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "cart"
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "2 160 Р",
                    color = Color.White
                )
            }

        }}
    }

    @Composable
    fun CatalogStart(modifier: Modifier = Modifier,
                products: List<UiProduct>,
                onClick: (UiProduct) -> Unit){
        Column {
            Row (){
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                        .wrapContentHeight()
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.group_10_1),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Text(text = "Пиломатериалы")
            }
        }
    }



