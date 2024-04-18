package ru.ll.productstest.domain

interface TagsUseCase {
    suspend fun getData(): List<UiTags>
}