package ru.ll.productstest.domain

interface TagsRepository {
    suspend fun getData(): List<UiTag>
}