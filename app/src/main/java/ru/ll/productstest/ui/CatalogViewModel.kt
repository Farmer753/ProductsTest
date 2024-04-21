package ru.ll.productstest.ui

import androidx.lifecycle.ViewModel
import ru.ll.productstest.domain.CategoriesRepository
import ru.ll.productstest.domain.ProductsRepository
import ru.ll.productstest.domain.TagsRepository

class CatalogViewModel(
    private val productsRepository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
    private val tagsRepository: TagsRepository
) : ViewModel() {
}