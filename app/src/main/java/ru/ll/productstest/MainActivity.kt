package ru.ll.productstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.ll.productstest.ui.CatalogScreen
import ru.ll.productstest.ui.ProductScreen
import ru.ll.productstest.ui.theme.ProductsTestTheme

class MainActivity : ComponentActivity() {

    @Serializable
    object Catalog

    // Define a asset page destination that takes an ID
    @Serializable
    data class SubCatalog(val instrumentId: String)
    @Serializable
    data class CategoryProducts(val instrumentId: String)

    @Serializable
    data class Product(val instrumentId: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTestTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Catalog) {
                    composable<Catalog> {
                        CatalogScreen(
                            onCategorySlugClick = { instrumentId ->
//                                navController.navigate(
//                                    AssetPage(instrumentId = instrumentId)
//                                )
                                navController.navigate(Product("Продукт"))
                            }
                        )
                    }
                    composable<Product> {
                        ProductScreen()
                    }
//                    composable<SubCatalog> { backStackEntry ->
//                        val subCatalog: SubCatalog = backStackEntry.toRoute()
//                        AssetPageScreen(
//                            instrumentId = subCatalog.instrumentId
//                        )
//                    }
                }

                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}

// Define a home destination that doesn't take any arguments


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsTestTheme {
        Greeting("Android")
    }


}