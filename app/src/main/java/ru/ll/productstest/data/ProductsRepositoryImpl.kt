package ru.ll.productstest.data

import ru.ll.productstest.domain.ProductsRepository
import ru.ll.productstest.domain.UiProduct
import ru.ll.productstest.domain.api.ProductsApi

class ProductsRepositoryImpl(
    private val productsApi: ProductsApi,
    private val converter: Converter
) : ProductsRepository {
    override suspend fun getData(): List<UiProduct> {
        return productsApi.getAllProducts().map { converter.convert(it) }
    }
}