package ru.ll.productstest.domain

interface CategoriesUseCase {
    suspend fun getData(): List<UiCategories>
}