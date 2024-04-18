package ru.ll.productstest.domain

interface ProductsUseCase {
    suspend fun getData(): List<UiProducts>
}