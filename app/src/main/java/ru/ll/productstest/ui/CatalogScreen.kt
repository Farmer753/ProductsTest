package ru.ll.productstest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ll.productstest.R
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
        val selected = remember {
            mutableStateOf(false)
        }
        SelectableButton(selected = selected.value, text = "Роллы") {
            selected.value = selected.value.not()
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
        }
    ) {
        Text(text = text)
    }
}
