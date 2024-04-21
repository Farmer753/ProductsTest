package ru.ll.productstest.domain

interface CategoriesRepository {
    suspend fun getData(): List<UiCategory>
}