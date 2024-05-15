package ru.ll.productstest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.ll.productstest.R
import ru.ll.productstest.domain.UiCategory
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.domain.test
import ru.ll.productstest.ui.theme.Dark60
import ru.ll.productstest.ui.theme.ProductsTestTheme

@Preview
@Composable
fun CatalogPreview() {
    ProductsTestTheme {
        Catalog()
    }
}

@Composable
fun Catalog() {

    Column {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Box(modifier = Modifier.padding(10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "filter"
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo"
                )
            }
            Box(modifier = Modifier.padding(10.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search"
                )
            }
        }
        val categories: MutableState<List<UiCategory>> = remember {
            mutableStateOf(
                listOf(
                    UiCategory(1, "Роллы", true),
                    UiCategory(2, "Суши"),
                    UiCategory(3, "Наборы"),
                    UiCategory(4, "Горячие блюда"),
                )
            )
        }
        Categories(categories.value) { selectedCategory ->
            categories.value = categories.value.map { category ->
//                val category = categories[it]
                if (category.id == selectedCategory.id) {
                    category.copy(selected = true)
                } else {
                    category.copy(selected = false)
                }
            }
        }
        val products: MutableState<List<UiProduct>> = remember {
            mutableStateOf(
                (1..100).map { test() }
            )
        }
        Products(
            modifier = Modifier.weight(1f),
            products.value
        ) {
//          TODO
        }
        Box(modifier = Modifier.padding(16.dp, 12.dp)) {
            Button(
                onClick = { },
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

        }
    }


}

@Composable
fun SelectableButton(
    selected: Boolean,
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        colors = if (selected) {
            ButtonDefaults.buttonColors()
        } else {
            ButtonDefaults.textButtonColors()
        },
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            color = if (selected) {
                Color.White
            } else {
                Color.Unspecified
            }
        )
    }

}

@Composable
fun Categories(
    categories: List<UiCategory>,
    onClick: (UiCategory) -> Unit
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)

    ) {
        categories.forEach {
            SelectableButton(it.selected, it.name) { onClick(it) }
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
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products) { product ->
            Product(product = product)
        }
    }
}

//TODO
@Composable
fun Product(
    product: UiProduct
) {
    Card {
        Column {
            AsyncImage(
                model = UiProduct.TOM,
                contentDescription = "test",
                placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//                    TODO fix AsyncImage
                    .size(100.dp)
            )
            Text(
                text = product.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${product.measure} ${product.measureUnit}",
                style = MaterialTheme.typography.body2.copy(color = Dark60)
            )
        }
    }
}