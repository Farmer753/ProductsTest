package ru.ll.productstest.domain

interface ProductsRepository {
    suspend fun getData(): List<UiProduct>
}