package ru.ll.productstest.ui.categoryproducts

import androidx.lifecycle.ViewModel
import ru.ll.productstest.domain.CategoriesRepository
import ru.ll.productstest.domain.ProductsRepository
import ru.ll.productstest.domain.TagsRepository

class CategoryProductsViewModel(
    private val productsRepository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
    private val tagsRepository: TagsRepository
) : ViewModel() {
}