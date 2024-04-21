package ru.ll.productstest.data

import ru.ll.productstest.domain.CategoriesRepository
import ru.ll.productstest.domain.UiCategory
import ru.ll.productstest.domain.api.CategoriesApi

class CategoriesRepositoryImpl(
    private val categoriesApi: CategoriesApi,
    private val converter: Converter
) : CategoriesRepository {
    override suspend fun getData(): List<UiCategory> {
        return categoriesApi.getAllCategories().map { converter.convert(it) }
    }
}