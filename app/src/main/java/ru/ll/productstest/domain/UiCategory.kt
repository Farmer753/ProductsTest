package ru.ll.productstest.domain

import kotlinx.serialization.Serializable

@Serializable
data class UiCategory(
    val id: Int,
    val name: String,
    val selected: Boolean = false
)
