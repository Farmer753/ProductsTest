package ru.ll.productstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import ru.ll.productstest.domain.UiCategory
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.ui.catalog.CatalogScreen
import ru.ll.productstest.ui.categoryproducts.CategoryProductsScreen
import ru.ll.productstest.ui.product.ProductScreen
import ru.ll.productstest.ui.subcatalog.SubCatalogScreen
import ru.ll.productstest.ui.theme.ProductsTestTheme

class MainActivity : ComponentActivity() {

    @Serializable
    object Catalog

    // Define a asset page destination that takes an ID
    @Serializable
    data class SubCatalog(val uiCategory: UiCategory)

    @Serializable
    data class CategoryProducts(val categorySlug: String)

    @Serializable
    data class Product(val product: UiProduct)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTestTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Catalog) {
                    composable<Catalog> {
                        CatalogScreen(
                            onCategorySlugClick = { categorySlug ->
                                navController.navigate(CategoryProducts(categorySlug))
                            },
                            onCategoryClick = { category ->
                                navController.navigate(SubCatalog(category))
                            }
                        )
                    }
                    composable<SubCatalog> {
                        SubCatalogScreen(
                            onCategorySlugClick = { categorySlug ->
                                navController.navigate(CategoryProducts(categorySlug))
                            },
                            onCategoryClick = { category ->
                                navController.navigate(SubCatalog(category))
                            }
                        )
                    }
                    composable<CategoryProducts> { backStackEntry ->
                        val categorySlug: String = backStackEntry.toRoute()
                        CategoryProductsScreen(categorySlug) {
                            navController.navigate(Product(it))
                        }
                    }
                    composable<Product> { backStackEntry ->
                        val product: UiProduct = backStackEntry.toRoute()
                        ProductScreen()
                    }
                }
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