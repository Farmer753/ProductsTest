package ru.ll.productstest.data

import ru.ll.productstest.domain.TagsRepository
import ru.ll.productstest.domain.UiTag
import ru.ll.productstest.domain.api.TagsApi

class TagsRepositoryImpl(
    private val tagsApi: TagsApi,
    private val converter: Converter
) : TagsRepository {
    override suspend fun getData(): List<UiTag> {
        return tagsApi.getAllTags().map { converter.convert(it) }
    }
}